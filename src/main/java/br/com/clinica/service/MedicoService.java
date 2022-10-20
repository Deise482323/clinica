package br.com.clinica.service;

import br.com.clinica.exeption.MedicoNaoEncontradoException;
import br.com.clinica.entity.Medico;
import br.com.clinica.http.domain.MedicoResponse;
import br.com.clinica.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {
    @Autowired
    private MedicoRepository repository;

    public void salvar(Medico medico) {
        repository.save(medico);
    }

    public List<MedicoResponse> findAll() {
        List<Medico> entity = repository.findAll();
        List<MedicoResponse> response = new ArrayList<>();

        for (Medico e : entity) {
            MedicoResponse medico = new MedicoResponse();
            medico.setCrm(e.getCrm());
            medico.setEspecialidade(e.getEspecialidade());
            medico.setNome(e.getNome());
            medico.setDdd(e.getDdd());
            medico.setNumero(e.getNumero());
            response.add(medico);
        }

        return response;
    }

    public MedicoResponse findById(Long id) {
        Optional<Medico> entity = repository.findById(id);
        if (entity.isPresent()) {
            Medico e = entity.get();
            MedicoResponse medico = new MedicoResponse();
            medico.setCrm(e.getCrm());
            medico.setEspecialidade(e.getEspecialidade());
            medico.setNome(e.getNome());
            medico.setDdd(e.getDdd());
            medico.setNumero(e.getNumero());
            return medico;
        } else {
            throw new MedicoNaoEncontradoException();
        }
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void atualizar(Long id, Medico medico) {
        Optional<Medico> res = repository.findById(id);
        if (res.isPresent()) {
            Medico medicoDb = res.get();
            medicoDb.setCrm(medico.getCrm());
            medicoDb.setNome(medico.getNome());
            medicoDb.setEspecialidade(medico.getEspecialidade());
            medicoDb.setDdd(medicoDb.getDdd());
            medicoDb.setNumero(medico.getNumero());
            medicoDb.setId(medico.getId());

            repository.save(medicoDb);

        } else {
            throw new MedicoNaoEncontradoException();
        }

    }
}

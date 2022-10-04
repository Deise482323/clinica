package br.com.clinica.service;

import br.com.clinica.model.Medico;
import br.com.clinica.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {
    @Autowired
    private MedicoRepository repository;

    public void salvar(Medico medico) {
        repository.save(medico);
    }

    public List<Medico> findAll() {
        return repository.findAll();
    }

    public Medico findById(Long id) {
        return repository.findById(id).get();
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
            System.out.println("médico não encontrado");
        }

    }
}

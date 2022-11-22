package br.com.clinica.service;

import br.com.clinica.entity.Funcionario;
import br.com.clinica.repository.FuncionarioRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepositoryImpl repository;

    public void salvar(Funcionario funcionario) {
        repository.salvar(funcionario);
    }

    public void update(String cpf, String nomeFuncionario, Long id) {
        repository.update(cpf, nomeFuncionario, id);
    }

    public void delete(Long id) {
        repository.delete(id);
    }
}

package br.com.clinica.repository;

import br.com.clinica.entity.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FuncionarioRepositoryImpl {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void salvar(Funcionario funcionario) {
        //escrever a query
        String sql = "INSERT INTO tb_funcionario(cpf, nome) VALUES ( '" + funcionario.getCpf() + " ','" + funcionario.getNome() + "');";
        Map<String, Object> params = new HashMap<>();
        //executar a query
        jdbcTemplate.update(sql, params);
    }
}

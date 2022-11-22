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

    public void update(String nomeFuncionario, String cpf, Long id) {
        String sql = "UPDATE tb_funcionario SET nome = '" + nomeFuncionario + "',  cpf = " + cpf + " WHERE id = " + id + ";";
        System.out.println(sql);
        Map<String, Object> params = new HashMap<>();
        //executar a query
        jdbcTemplate.update(sql, params);
    }

    public void delete(Long id) {
        String sql = "DELETE FROM tb_funcionario WHERE id = " + id + ";";
        System.out.println(sql);
        Map<String, Object> params = new HashMap<>();
        //executar a query
        jdbcTemplate.update(sql, params);
    }

}

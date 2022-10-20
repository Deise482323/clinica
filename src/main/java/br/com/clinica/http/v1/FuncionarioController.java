package br.com.clinica.http.v1;

import br.com.clinica.entity.Funcionario;
import br.com.clinica.service.FuncionarioService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequestMapping(path = "/api/v1/funcionario")
@Api(tags = "funcionario", produces = APPLICATION_JSON_VALUE)
@CrossOrigin
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void salvar(@RequestBody Funcionario funcionario) {
        service.salvar(funcionario);
    }
}

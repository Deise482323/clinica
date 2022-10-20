package br.com.clinica.http.v1;

import br.com.clinica.entity.Medico;
import br.com.clinica.http.domain.MedicoResponse;
import br.com.clinica.service.MedicoService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequestMapping(path = "/api/v1/medico")
@Api(tags = "Medico", produces = APPLICATION_JSON_VALUE)
@CrossOrigin
public class MedicoController {
    @Autowired
    private MedicoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void salvar(@RequestBody Medico medico) {
        service.salvar(medico);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MedicoResponse> findAll() {
        return service.findAll();
    }


    @GetMapping("/por-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MedicoResponse findById(@RequestParam("id") Long id) {
        return service.findById(id);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(Long id) {
        service.deleteById(id);
    }

    @PutMapping("/update-por-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizar(@RequestParam("id") Long id, @RequestBody Medico medico) {
        service.atualizar(id, medico);
    }

}

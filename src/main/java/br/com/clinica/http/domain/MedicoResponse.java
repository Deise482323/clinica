package br.com.clinica.http.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data //medtodos da classe
@Builder //medtodos da classe
@AllArgsConstructor //medtodos da classe
@NoArgsConstructor //medtodos da classe

public class MedicoResponse {

    private String crm;
    private String nome;
    private int ddd;
    private long numero;
    private String especialidade;

}

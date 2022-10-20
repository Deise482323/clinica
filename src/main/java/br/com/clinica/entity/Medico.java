package br.com.clinica.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data //medtodos da classe
@Entity //base de dados
@Builder //medtodos da classe
@AllArgsConstructor //medtodos da classe
@NoArgsConstructor //medtodos da classe
@Table(name = "TB_MEDICO")
public class Medico implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    private String crm;
    private String nome;
    private int ddd;
    private long numero;
    private String especialidade;

}

package com.tech.projetoTech.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Pessoa {
    public enum Sexo{
        MASCULINO,
        FEMININO,
        OUTROS,
        SEM
    }
  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Nome é obrigatória")
    @NotNull(message = "Nome não pode ser nulo ")
    private String nome;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate data_nascimento;
    @NotBlank(message = "E-mail é obrigatória")
    @NotNull(message = "E-mail não pode ser nulo ")

    private String email;

    @NotBlank(message = "Telefone é obrigatório")
    @NotNull(message = "Telefone não pode ser nulo ")
    private String telefone;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    public void setSexo(String sexo) {
        this.sexo = Sexo.valueOf(sexo.toUpperCase());
    }
    public void setNome(String nome){
        this.nome = nome.toUpperCase();
    }
    public void setEmail(String email) {
        this.email= email.toLowerCase();
    }

}

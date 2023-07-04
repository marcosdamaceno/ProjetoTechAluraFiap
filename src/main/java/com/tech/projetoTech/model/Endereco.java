package com.tech.projetoTech.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Rua é obrigatória")
    @NotNull(message = "Rua não pode ser nula ")
    private String rua;
    private String numero;
    @NotBlank(message = "Bairro é obrigatório")
    @NotNull(message = "Bairro não pode ser nulo ")
    private String bairro;
    @NotBlank(message = "Cidade é obrigatória")
    @NotNull(message = "Cidade não pode ser nula ")
    private String cidade;
    @NotBlank(message = "Estado é obrigatório")
    @NotNull(message = "Estado não pode ser nulo ")
    private String estado;


    public void setRua(String rua){
        this.rua = rua.toUpperCase();
    }
    public void setBairro (String bairro){
        this.bairro = bairro.toUpperCase();
    }

    public void setCidade(String cidade){
        this.cidade=cidade.toUpperCase();
    }

    public void setEstado(String estado){
        this.estado=estado.toUpperCase();
    }

}

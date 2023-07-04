package com.tech.projetoTech.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;

@Entity
@Getter
@Setter
public class EletroDomestico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @NotNull(message = "Nome não pode ser nulo")
    private String nome;

    @NotBlank(message = "Marca é obrigatória")
    @NotNull(message = "Marca não pode ser nula")
    private String marca;

    @NotBlank(message = "Potência é obrigatória")
    @NotNull(message = "Potência não pode ser nula")
    private Double potencia; // Potência em watts

    @NotBlank(message = "tempoUsoDiario é obrigatória")
    @NotNull(message = "tempoUsoDiario não pode ser nula")
    private Double tempoUsoDiario; // Tempo de uso diário em horas

    @NotBlank(message = "consumoStandby é obrigatória")
    @NotNull(message = "consumoStandby não pode ser nula")
    private Double consumoStandby;

    public void setNome(String nome) {
        this.nome = nome.toUpperCase();
    }

    public void setMarca(String marca) {
        this.marca = marca.toUpperCase();
    }
}

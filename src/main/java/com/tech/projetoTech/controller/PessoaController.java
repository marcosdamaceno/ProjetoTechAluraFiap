package com.tech.projetoTech.controller;

import com.tech.projetoTech.model.Pessoa;
import com.tech.projetoTech.repository.PessoaRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoa")
@Tag(name = "Pessoa", description = "API para gestão de pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @PostMapping
    @Operation(summary = "Adicionar uma pessoa")
    public ResponseEntity<Pessoa>addPessoa(@Valid @RequestBody Pessoa pessoa) {
        try {
            Pessoa savePessoa = pessoaRepository.save(pessoa);
            return new ResponseEntity<>(savePessoa, HttpStatus.CREATED);
        } catch (Exception e){
            System.out.println("Erro ao salvar o pessoa: " + e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping
    @ApiOperation(value = "Buscar todas as pessoas")
    public ResponseEntity<List<Pessoa>> getAllPessoas() {
        try {
            List<Pessoa> pessoas = pessoaRepository.findAll();
            if (pessoas.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(pessoas, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Erro ao buscar as pessoas: " + e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Buscar uma pessoa pelo ID")
    public ResponseEntity<Pessoa> getPessoaById(@PathVariable Long id) {
        try {
            Optional<Pessoa> pessoa = pessoaRepository.findById(id);
            return pessoa.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            System.out.println("Erro ao buscar a pessoa: " + e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualizar uma pessoa")
    public ResponseEntity<Pessoa> updatePessoa(
            @PathVariable Long id, @Valid @RequestBody Pessoa pessoa) {
        try {
            Optional<Pessoa> existingPessoa = pessoaRepository.findById(id);
            if (existingPessoa.isPresent()) {
                Pessoa updatedPessoa = existingPessoa.get();
                updatedPessoa.setNome(pessoa.getNome());

                Pessoa savedPessoa = pessoaRepository.save(updatedPessoa);
                return new ResponseEntity<>(savedPessoa, HttpStatus.OK);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            System.out.println("Erro ao atualizar a pessoa: " + e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deletar uma pessoa")
    public ResponseEntity<HttpStatus> deletePessoa(@PathVariable Long id) {
        try {
            pessoaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            System.out.println("Erro ao deletar a pessoa: " + e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


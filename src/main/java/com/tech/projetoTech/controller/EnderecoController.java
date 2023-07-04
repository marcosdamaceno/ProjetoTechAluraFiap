package com.tech.projetoTech.controller;
import com.tech.projetoTech.model.Endereco;
import com.tech.projetoTech.repository.EnderecoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enderecos")
@Api(tags = "Endereço", description = "API para gestão de endereços")
public class EnderecoController {
    @Autowired
    private EnderecoRepository enderecoRepository;

    @PostMapping
    @ApiOperation(value = "Cadastrar um endereço. ")
    public ResponseEntity<Endereco> addEndereco(@Valid @RequestBody Endereco endereco){
        System.out.println(endereco.getBairro());

        try {
            Endereco  saveEndereco = enderecoRepository.save(endereco);
            return new ResponseEntity<>(saveEndereco, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println("Erro ao salvar o endereço: " + e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    @ApiOperation(value = "Buscar todos os endereços")
    public ResponseEntity<List<Endereco>> getAllEnderecos() {
        try {
            List<Endereco> enderecos = enderecoRepository.findAll();
            if (enderecos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(enderecos, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Erro ao buscar os endereços: " + e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Buscar todos os endereços")
    public ResponseEntity<Endereco> getEnderecoById(@PathVariable Long id) {
        try {
            Optional<Endereco> endereco = enderecoRepository.findById(id);
            return endereco.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            System.out.println("Erro ao buscar o endereço: " + e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Buscar um endereço pelo ID")
    public ResponseEntity<Endereco> updateEndereco(
            @PathVariable Long id, @Valid @RequestBody Endereco endereco) {
        try {
            Optional<Endereco> existingEndereco = enderecoRepository.findById(id);
            if (existingEndereco.isPresent()) {
                Endereco updatedEndereco = existingEndereco.get();
                updatedEndereco.setBairro(endereco.getBairro());
                updatedEndereco.setCidade(endereco.getCidade());


                Endereco savedEndereco = enderecoRepository.save(updatedEndereco);
                return new ResponseEntity<>(savedEndereco, HttpStatus.OK);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            System.out.println("Erro ao atualizar o endereço: " + e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deletar um endereço")
    public ResponseEntity<HttpStatus> deleteEndereco(@PathVariable Long id) {
        try {
            enderecoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            System.out.println("Erro ao deletar o endereço: " + e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

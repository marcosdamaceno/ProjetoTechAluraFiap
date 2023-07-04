package com.tech.projetoTech.controller;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import com.tech.projetoTech.model.EletroDomestico;
import com.tech.projetoTech.repository.EletrodomesticoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Source;

import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/eletrodomestico")
@Api(tags = "EletroDomestico", description = "API para gestão de eletrodomésticos")
public class EletrodomesticoController {
    @Autowired
    private EletrodomesticoRepository eletrodomesticoRepository;

    @GetMapping("/{id}")
    @ApiOperation(value = "Buscar um eletrodoméstico pelo ID")
    public ResponseEntity<EletroDomestico> getEletroDomestico(@PathVariable Long id) {
        try {
            Optional<EletroDomestico> eletroDomestico = eletrodomesticoRepository.findById(id);
            return eletroDomestico.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            System.out.println("Erro ao buscar o eletrodoméstico" + e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping
    @ApiOperation(value = "Cadastrar um eletrodoméstico")
    public ResponseEntity<EletroDomestico> addEletroDomestico(@Valid @RequestBody EletroDomestico eletroDomestico){
        try {
            EletroDomestico saveEletroDomestico  = eletrodomesticoRepository.save(eletroDomestico) ;
            return new ResponseEntity<>(saveEletroDomestico, HttpStatus.CREATED);
        }catch (Exception e ){
            System.out.println("Erro ao salvar o edereço" + e.getMessage());
            e.printStackTrace();
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualizar um eletrodoméstico")
    public ResponseEntity<EletroDomestico> updateEletroDomestico(
            @PathVariable Long id, @Valid @RequestBody EletroDomestico eletroDomestico) {
        try {
            Optional<EletroDomestico> existingEletroDomestico = eletrodomesticoRepository.findById(id);
            if (existingEletroDomestico.isPresent()) {
                EletroDomestico updatedEletroDomestico = existingEletroDomestico.get();
                updatedEletroDomestico.setNome(eletroDomestico.getNome());


                EletroDomestico savedEletroDomestico = eletrodomesticoRepository.save(updatedEletroDomestico);
                return new ResponseEntity<>(savedEletroDomestico, HttpStatus.OK);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            System.out.println("Erro ao atualizar o eletrodoméstico" + e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deletar um eletrodoméstico")
    public ResponseEntity<HttpStatus> deleteEletroDomestico(@PathVariable Long id) {
        try {
            eletrodomesticoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            System.out.println("Erro ao deletar o eletrodoméstico" + e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


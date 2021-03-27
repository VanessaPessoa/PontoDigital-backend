package com.learning.pontodigital.controller;

import com.learning.pontodigital.entities.DTO.HoraDTO;
import com.learning.pontodigital.repository.HoraRepository;
import com.learning.pontodigital.service.HoraService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.learning.pontodigital.models.Hora;
import org.springframework.data.web.JsonPath;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/hora")
@Slf4j
public class HoraController {
    @Autowired
    private HoraService horaService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody HoraDTO horaDTO){
        Hora hora = this.horaService.create(horaDTO);
        if(hora == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(hora, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> readAll(){
        return new ResponseEntity<>(this.horaService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> readByID(@PathVariable int id){
        return new ResponseEntity<>(this.horaService.getById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        boolean response = this.horaService.delete(id);
        if(!response){
            new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody HoraDTO horaDTO){
        horaDTO.setId(id);
        Hora update = this.horaService.update(horaDTO);

        if(update == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(update, HttpStatus.OK);
    }
}

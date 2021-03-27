package com.learning.pontodigital.controller;


import com.learning.pontodigital.entities.DTO.CategoriaDTO;
import com.learning.pontodigital.models.Categoria;
import com.learning.pontodigital.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CategoriaDTO categoriaDTO){
        Categoria categoria = this.categoriaService.create(categoriaDTO);
        if(categoria == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(categoria, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> readById(@PathVariable int id){
        return new ResponseEntity<>(this.categoriaService.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> readAll(){
        return new ResponseEntity<>(this.categoriaService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        boolean response = this.categoriaService.delete(id);
        if(response){
            return new ResponseEntity<>(null, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody CategoriaDTO categoriaDTO){
        categoriaDTO.setId(id);
        Categoria update = this.categoriaService.update(categoriaDTO);

        if(update == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(update, HttpStatus.OK);

    }
}

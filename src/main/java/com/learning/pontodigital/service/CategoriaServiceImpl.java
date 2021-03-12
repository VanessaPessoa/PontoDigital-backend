package com.learning.pontodigital.service;

import com.learning.pontodigital.entities.DTO.CategoriaDTO;
import com.learning.pontodigital.models.Categoria;
import com.learning.pontodigital.repository.CategoriaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public Categoria create(CategoriaDTO categoriaDTO) {
        Categoria categoria;

        try {
            categoria = this.categoriaRepository.save(categoriaDTO.getModel());
        }catch (Exception e){
            log.info("Exception to create Categoria: "+ e.getMessage() );
            categoria = null;
        }

        return categoria;
    }

    @Override
    public List<Categoria> getAll() {
        return StreamSupport
                .stream(this.categoriaRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Categoria getById(int id) {
        Categoria categoria;
        categoria = this.categoriaRepository.findById(Long.valueOf(id)).orElse(null);

        return categoria;
    }

    @Override
    public Categoria update(CategoriaDTO categoriaDTO) {
        return this.create(categoriaDTO);
    }

    @Override
    public boolean delete(int id) {
        boolean response = true;
        try{
            this.categoriaRepository.delete(this.getById(id));
        }catch (Exception e){
            log.info("Exception to delete Categoria: "+ e.getMessage() );
            response = false;
        }
        return response;
    }
}

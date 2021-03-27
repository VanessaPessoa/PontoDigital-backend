package com.learning.pontodigital.service;

import com.learning.pontodigital.entities.DTO.CategoriaDTO;
import com.learning.pontodigital.entities.DTO.HoraDTO;
import com.learning.pontodigital.models.Categoria;
import com.learning.pontodigital.models.Hora;
import com.learning.pontodigital.repository.HoraRepository;
import com.sun.jdi.LongValue;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Service
public class HoraServiceImpl implements HoraService {

    @Autowired
    private HoraRepository horaRepository;

    @Override
    public Hora create(HoraDTO horaDTO) {
        Hora hora;
        try {
            hora = this.horaRepository.save(horaDTO.getModel());
        } catch (Exception e) {
            log.info("Exception to create Hora: " + e.getMessage());
            hora = null;
        }

        return hora;
    }

    @Override
    public List<Hora> getAll() {

        return StreamSupport
                .stream(this.horaRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Hora getById(int id) {
        Hora hora;
        hora = this.horaRepository.findById(Long.valueOf(id)).orElse(null);
        return hora;
    }

    @Override
    public Hora update(HoraDTO horaDTO){ return this.create(horaDTO); }

    @Override
    public boolean delete(int id) {
        boolean response = true;
        try {
            this.horaRepository.delete(this.getById(id));
        } catch (Exception e) {
            log.info("Exception to delete Hora: " + e.getMessage());
            response = false;
        }
        return response;
    }
}

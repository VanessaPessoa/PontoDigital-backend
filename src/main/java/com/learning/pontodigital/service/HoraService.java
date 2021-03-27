package com.learning.pontodigital.service;

import com.learning.pontodigital.domain.CrudAbstract;
import com.learning.pontodigital.entities.DTO.HoraDTO;
import com.learning.pontodigital.models.Hora;
import org.springframework.http.ResponseEntity;

public interface HoraService extends CrudAbstract<Hora,HoraDTO> {
}

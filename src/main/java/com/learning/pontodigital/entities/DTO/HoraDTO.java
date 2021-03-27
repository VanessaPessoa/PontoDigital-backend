package com.learning.pontodigital.entities.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learning.pontodigital.domain.DTOAdapter;
import com.learning.pontodigital.models.Categoria;
import com.learning.pontodigital.models.Hora;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class HoraDTO implements DTOAdapter<Hora> {

    public long id;

    private Time entrada;

    private Time saida;

    private Categoria categoria;

    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date data;

    @JsonIgnore
    public Hora getModel() {
        return Hora.builder()
                .id(this.id)
                .entrada(this.entrada)
                .saida(this.saida)
                .categoria(this.categoria)
                .data(this.data)
                .build();
    }
}

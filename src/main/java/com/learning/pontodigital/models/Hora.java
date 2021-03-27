package com.learning.pontodigital.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learning.pontodigital.domain.ModelAdapter;
import com.learning.pontodigital.entities.DTO.CategoriaDTO;
import com.learning.pontodigital.entities.DTO.HoraDTO;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Hora implements Serializable, ModelAdapter<HoraDTO> {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private Time entrada;

    @Column
    private Time saida;

    @OneToOne
    private Categoria categoria;

    @Column
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date data;

    @JsonIgnore
    public HoraDTO getDTO() {
        return HoraDTO.builder()
                .id(this.id)
                .entrada(this.entrada)
                .saida(this.saida)
                .categoria(this.categoria)
                .data(this.data)
                .build();
    }
}


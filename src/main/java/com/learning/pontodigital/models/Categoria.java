package com.learning.pontodigital.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learning.pontodigital.domain.ModelAdapter;
import com.learning.pontodigital.entities.DTO.CategoriaDTO;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Categoria  implements Serializable, ModelAdapter<CategoriaDTO> {

    @Id @GeneratedValue
    private long id;

    @Column(nullable = true)
    private boolean active = true;

    @Column(unique = true, nullable = false)
    private String name;

    @Column
    private int horasDiarias;

    @Column
    private int horasSemanais;

    @JsonIgnore
    public CategoriaDTO getDTO() {
        return CategoriaDTO.builder()
                .id(this.id)
                .active(this.active)
                .name(this.name)
                .horasDiarias(this.horasDiarias)
                .horasSemanais(horasSemanais)
                .build();
    }
}

package com.learning.pontodigital.entities.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learning.pontodigital.domain.DTOAdapter;
import com.learning.pontodigital.models.Categoria;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO implements DTOAdapter<Categoria> {

    public CategoriaDTO(boolean active, String name, int horasDiarias, int horasSemanais) {
        this.active = active;
        this.name = name;
        this.horasDiarias = horasDiarias;
        this.horasSemanais = horasSemanais;
    }


    private long id;

    private boolean active;

    private String name;

    private int horasDiarias;

    private int horasSemanais;

    @JsonIgnore
    public Categoria getModel() {
        return Categoria.builder()
                .id(this.id)
                .active(this.active)
                .name(this.name)
                .horasDiarias(this.horasDiarias)
                .horasSemanais(horasSemanais)
                .build();
    }
}

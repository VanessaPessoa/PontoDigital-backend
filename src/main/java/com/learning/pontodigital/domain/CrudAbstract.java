package com.learning.pontodigital.domain;

import java.util.List;

public interface CrudAbstract<Model,DTOAdapter> {

    //Create
    public Model create(DTOAdapter dtoAdapter);

    //Read
     public List<Model> getAll();
     public Model getById(int id);

    //Update
     public Model update(DTOAdapter dtoAdapter);

    //Delete
     public boolean delete(int id);

}

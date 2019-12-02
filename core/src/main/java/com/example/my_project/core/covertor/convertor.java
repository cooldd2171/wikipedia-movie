package com.example.my_project.core.covertor;

public interface convertor<I,O> {

    I convertToEntity(O model);

    O convertToModel(I entity);

}

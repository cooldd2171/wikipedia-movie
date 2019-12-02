package com.example.demo.covertor;

public interface convertor<I,O> {

    I convertToEntity(O model);

    O converToModel(I entity);

}

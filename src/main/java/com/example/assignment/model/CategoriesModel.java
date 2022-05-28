package com.example.assignment.model;

import com.example.assignment.entity.Categories;

import java.util.List;

public interface CategoriesModel {
    Categories save(Categories obj);
    List<Categories> findAll();
    Categories findById(int Id);
    Categories update(int Id, Categories updateObj);
    boolean delete(int Id);
}

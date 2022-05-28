package com.example.assignment.model;

import com.example.assignment.entity.Categories;
import com.example.assignment.entity.FoodInformation;

import java.util.List;

public interface FoodInformationModel {
    FoodInformation save(FoodInformation obj);
    List<FoodInformation> findAll();
    FoodInformation findById(int Id);
    FoodInformation update(int Id, FoodInformation updateObj);
    boolean delete(int Id);
}

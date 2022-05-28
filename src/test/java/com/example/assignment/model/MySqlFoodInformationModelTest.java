package com.example.assignment.model;

import com.example.assignment.entity.FoodInformation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MySqlFoodInformationModelTest {

    private FoodInformationModel foodInformationModel;
    @BeforeEach
    void setUp() {
        foodInformationModel = new MySqlFoodInformationModel();
    }

    @Test
    public void create(){
        FoodInformation foodInformation = new FoodInformation();
        foodInformation.setName("Kitty");
        foodInformation.setCategoryId(1);
        foodInformation.setDetail("Đây là chú mèo vip pro");
        foodInformation.setThumbnail("kitty.img");
        foodInformation.setPrice(100);
        foodInformationModel.save(foodInformation);
    }
}
package com.example.assignment.model;

import com.example.assignment.entity.Categories;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MySqlCategoriesModelTest {

    private MySqlCategoriesModel model;
    @BeforeEach
    void setUp(){
        model = new MySqlCategoriesModel();
    }

    @Test
    public void create(){
        Categories categories = new Categories();
        categories.setName("Đồ uống");
        model.save(categories );
    }

    @Test
    public void update(){
        Categories categories = model.findById(1);
        assertNotEquals(null, categories);
    }
    @Test
    public void delete(){
        model.delete(1);
        assertNotEquals(1, model.findAll().size());
    }
}
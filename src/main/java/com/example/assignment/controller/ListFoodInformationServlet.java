package com.example.assignment.controller;

import com.example.assignment.entity.FoodInformation;
import com.example.assignment.model.FoodInformationModel;
import com.example.assignment.model.MySqlFoodInformationModel;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListFoodInformationServlet extends HttpServlet {

    private FoodInformationModel foodInformationModel;

    public ListFoodInformationServlet() {
        this.foodInformationModel = new MySqlFoodInformationModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<FoodInformation> list = foodInformationModel.findAll();
        req.setAttribute("listFoodInformation", list);
        req.getRequestDispatcher("/admin/FoodInformation/list.jsp").forward(req, resp);
    }
}

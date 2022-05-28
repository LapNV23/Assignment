package com.example.assignment.controller.user;

import com.example.assignment.entity.FoodInformation;
import com.example.assignment.model.FoodInformationModel;
import com.example.assignment.model.MySqlFoodInformationModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListFoodInformationUserServlet extends HttpServlet {
    private FoodInformationModel foodInformationModel;

    public ListFoodInformationUserServlet(){
        this.foodInformationModel = new MySqlFoodInformationModel();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<FoodInformation> foodInformations = foodInformationModel.findAll();
        req.setAttribute("foodInformations", foodInformations);
        req.getRequestDispatcher("/user/page/Products.jsp").forward(req,resp);
    }
}

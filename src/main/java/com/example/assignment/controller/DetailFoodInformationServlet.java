package com.example.assignment.controller;

import com.example.assignment.entity.FoodInformation;
import com.example.assignment.model.CategoriesModel;
import com.example.assignment.model.FoodInformationModel;
import com.example.assignment.model.MySqlCategoriesModel;
import com.example.assignment.model.MySqlFoodInformationModel;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DetailFoodInformationServlet extends HttpServlet {

    private FoodInformationModel foodInformationModel;
    private CategoriesModel categoriesModel;

    public DetailFoodInformationServlet() {
        this.foodInformationModel = new MySqlFoodInformationModel();
        this.categoriesModel = new MySqlCategoriesModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // lấy tham số rollNumber(id)
        int Id = Integer.parseInt(req.getParameter("Id"));
        // kiểm tra trong database xem có tồn tại không.
        FoodInformation obj = foodInformationModel.findById(Id);
        // nếu không trả về trang 404
        if (obj == null) {
            req.setAttribute("message", "Food information not found!");
            req.getRequestDispatcher("/admin/errors/404.jsp").forward(req, resp);
        } else {
            // nếu có trả về trang detail
            req.setAttribute("obj", obj);
            req.getRequestDispatcher("/admin/FoodInformation/detail.jsp").forward(req, resp);
        }

    }
}

package com.example.assignment.controller;

import com.example.assignment.entity.FoodInformation;
import com.example.assignment.model.FoodInformationModel;
import com.example.assignment.model.MySqlFoodInformationModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteFoodInformationServlet extends HttpServlet {

    private FoodInformationModel foodInformationModel;

    public DeleteFoodInformationServlet() {
        this.foodInformationModel = new MySqlFoodInformationModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // lấy tham số (id)
        int Id = Integer.parseInt(req.getParameter("Id"));
        // kiểm tra trong database xem có tồn tại không.
        FoodInformation foodInformation = foodInformationModel.findById(Id);
        // nếu không trả về trang 404
        if (foodInformation == null) {
            req.setAttribute("message", "Food Information not found!");
            req.getRequestDispatcher("/admin/errors/404.jsp").forward(req, resp);
        } else {
            boolean result = foodInformationModel.delete(Id); // xoá mềm.
            if (result) {
                resp.sendRedirect("/admin/FoodInformation/list");
            } else {
                req.setAttribute("message", "Action fails!");
                req.getRequestDispatcher("/admin/errors/500.jsp").forward(req, resp);
            }
        }
    }
}

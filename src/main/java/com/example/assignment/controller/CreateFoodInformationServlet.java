package com.example.assignment.controller;



import com.example.assignment.entity.FoodInformation;
import com.example.assignment.entity.myenum.FoodInformationStatus;
import com.example.assignment.model.CategoriesModel;
import com.example.assignment.model.FoodInformationModel;
import com.example.assignment.model.MySqlCategoriesModel;
import com.example.assignment.model.MySqlFoodInformationModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class CreateFoodInformationServlet extends HttpServlet {

    private FoodInformationModel foodInformationModel;
    private CategoriesModel categoriesModel;

    public CreateFoodInformationServlet() {
        this.foodInformationModel = new MySqlFoodInformationModel();
        this.categoriesModel = new MySqlCategoriesModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // trả về form.
        req.setAttribute("categories", categoriesModel.findAll());
        req.setAttribute("obj", new FoodInformation());
        req.setAttribute("action", 1);
        req.getRequestDispatcher("/admin/FoodInformation/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        // xử lý validate và save.
        String Name = req.getParameter("Name");
        int CategoryId = Integer.parseInt(req.getParameter("CategoryId"));
        int Status = Integer.parseInt(req.getParameter("Status"));
        String Detail = req.getParameter("Detail");
        String Thumbnail = req.getParameter("Thumbnail");
        double Price = Double.parseDouble(req.getParameter("Price"));
        System.out.println(Name);
        FoodInformation obj = new FoodInformation();
        obj.setName(Name);
        obj.setStatus(FoodInformationStatus.of(Status));
        obj.setCategoryId(CategoryId);
        obj.setDetail(Detail);
        obj.setThumbnail(Thumbnail);
        obj.setPrice(Price);
//        HashMap<String, String> errors = new HashMap<>();


        if (!obj.isValid()) {
            req.setAttribute("categories", categoriesModel.findAll());
            req.setAttribute("obj", obj);
            req.setAttribute("action", 1);
            req.setAttribute("errors", obj.getErrors());
            req.getRequestDispatcher("/admin/FoodInformation/form.jsp").forward(req, resp);
            return;
        }
        if (foodInformationModel.save(obj) != null) {
            resp.sendRedirect("/admin/FoodInformation/list");
        } else {
            req.getRequestDispatcher("/admin/FoodInformation/form.jsp").forward(req, resp);
        }
    }
}

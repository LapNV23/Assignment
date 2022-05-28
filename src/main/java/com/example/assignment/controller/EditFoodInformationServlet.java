package com.example.assignment.controller;



import com.example.assignment.entity.Categories;
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

public class EditFoodInformationServlet extends HttpServlet {

    private FoodInformationModel foodInformationModel;
    private CategoriesModel categoriesModel;

    public EditFoodInformationServlet() {
        this.foodInformationModel = new MySqlFoodInformationModel();
        this.categoriesModel = new MySqlCategoriesModel();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int Id = Integer.parseInt(req.getParameter("Id"));
        FoodInformation obj = foodInformationModel.findById(Id);

        if (obj == null){
            req.setAttribute("message","Data not found!");
            req.getRequestDispatcher("/admin/errors/404.jsp").forward(req,resp);
        }else {
            req.setAttribute("title", "Edit FoodInformation");
            req.setAttribute("categories", categoriesModel.findAll());
            req.setAttribute("product",obj);
            req.setAttribute("action",2);
            req.getRequestDispatcher("/admin/FoodInformation/form.jsp").forward(req, resp);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int Id = Integer.parseInt(req.getParameter("Id"));
        String Name = req.getParameter("Name");
        int CategoryId = Integer.parseInt(req.getParameter("CategoryId"));
        int Status = Integer.parseInt(req.getParameter("Status"));
        String Detail = req.getParameter("Detail");
        String Thumbnail = req.getParameter("Thumbnail");
        double Price = Double.parseDouble(req.getParameter("Price"));
        System.out.println(Name);
        FoodInformation obj = new FoodInformation();
        obj.setName(Name);
        obj.setCategoryId(CategoryId);
        obj.setDetail(Detail);
        obj.setThumbnail(Thumbnail);
        obj.setPrice(Price);
        obj.setStatus(FoodInformationStatus.of(Status));

        if (!obj.isValid()) {
            req.setAttribute("categories", categoriesModel.findAll());
            req.setAttribute("obj", obj);
            req.setAttribute("action", 2);
            req.setAttribute("errors", obj.getErrors());
            req.getRequestDispatcher("/admin/FoodInformation/form.jsp").forward(req, resp);
            return;
        }
//        if (foodInformationModel.update(Id, obj) != null){
//            resp.sendRedirect("/admin/FooInformation/list");
//        } else {
            req.setAttribute("categories", categoriesModel.findAll());
            req.setAttribute("title","Edit foodInformation");
            req.setAttribute("obj", obj);
            req.setAttribute("action", 2);
            req.getRequestDispatcher("/admin/FoodInformation/form.jsp").forward(req, resp);
//        }
    }
}

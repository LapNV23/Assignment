package com.example.assignment.controller.user;

import com.example.assignment.entity.FoodInformation;
import com.example.assignment.model.FoodInformationModel;
import com.example.assignment.model.MySqlFoodInformationModel;
import com.example.assignment.entity.shoppingcart.ShoppingCart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddCartServlet extends HttpServlet {
    private FoodInformationModel foodInformationModel;
    public AddCartServlet(){
        this.foodInformationModel = new MySqlFoodInformationModel();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ShoppingCart shoppingCart =(ShoppingCart) session.getAttribute("shoppingCart");
        if (shoppingCart == null){
            shoppingCart = new ShoppingCart();
        }

        try{
            int productId = Integer.parseInt(req.getParameter("productId"));
            int quantity = Integer.parseInt(req.getParameter("quantity"));
            FoodInformation foodInformation = foodInformationModel.findById(productId);
            if (foodInformation == null){
                req.getRequestDispatcher("/user/error/404.jsp").forward(req,resp);
                return;
            }
            if (quantity<=0){
                req.getRequestDispatcher("/user/error/404.jsp").forward(req,resp);
                return;
            }
            shoppingCart.add(foodInformation, quantity);
            session.setAttribute("shoppingCart",shoppingCart);
            resp.sendRedirect("/cart/show");
        } catch (Exception ex){
            req.getRequestDispatcher("/user/error/500.jsp").forward(req,resp);
        }
    }
}

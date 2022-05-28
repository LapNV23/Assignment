package com.example.assignment.entity.shoppingcart;

import com.example.assignment.entity.CartItem;
import com.example.assignment.entity.FoodInformation;

import java.util.ArrayList;

public interface ShoppingCartAction {
    void add(FoodInformation foodInformation, int quantity); // thêm số lượng sản phẩm vào cart.
    void update(FoodInformation foodInformation, int quantity); // thay đổi số lượng của sản phẩm trong cart.
    void remove(FoodInformation foodInformation); // remove sản phẩm khỏi cart.
    ArrayList<CartItem> getListItems();
}
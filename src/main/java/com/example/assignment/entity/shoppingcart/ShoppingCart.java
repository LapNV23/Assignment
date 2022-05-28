package com.example.assignment.entity.shoppingcart;

import com.example.assignment.entity.CartItem;
import com.example.assignment.entity.FoodInformation;

import java.util.ArrayList;
import java.util.HashMap;

public class ShoppingCart implements ShoppingCartAction {

    private String userId; // ai đặt
    private String shipName;
    private String shipPhone;
    private String shipAddress;
    private String shipNote;
    private double totalPrice;
    private HashMap<Integer, CartItem> items;

    public ShoppingCart() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipPhone() {
        return shipPhone;
    }

    public void setShipPhone(String shipPhone) {
        this.shipPhone = shipPhone;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getShipNote() {
        return shipNote;
    }

    public void setShipNote(String shipNote) {
        this.shipNote = shipNote;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public HashMap<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(HashMap<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public void add(FoodInformation foodInformation, int quantity) {
        if (items.containsKey(foodInformation.getId())){
            CartItem currentItem = items.get(foodInformation.getId());
            int numberQuantity = currentItem.getQuantity() + quantity;
            update(foodInformation, numberQuantity);
        } else {
            update(foodInformation, quantity);
        }
    }

    @Override
    public void update(FoodInformation foodInformation, int quantity) {
        if (items.containsKey(foodInformation.getId())){
            CartItem currentItem = items.get(foodInformation.getId());
            currentItem.setQuantity(quantity);
            items.put(foodInformation.getId(), currentItem);
        } else {
            CartItem item = new CartItem();
            item.setProductId(foodInformation.getId());
            item.setProductName(foodInformation.getName());
            item.setProductThumbnail(foodInformation.getThumbnail());
            item.setUnitPrice(foodInformation.getPrice());
            item.setQuantity(quantity);
            items.put(foodInformation.getId(), item);
        }
    }

    @Override
    public void remove(FoodInformation foodInformation) {
        if (items.containsKey(foodInformation.getId())){
            items.remove(foodInformation.getId());
        }
    }

    @Override
    public ArrayList<CartItem> getListItems() {
        return new ArrayList<>(items.values());
    }

}
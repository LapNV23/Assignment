package com.example.assignment.entity;

import com.example.assignment.entity.base.BaseEntity;
import com.example.assignment.entity.myenum.FoodInformationStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FoodInformation extends BaseEntity {
    private int Id;
    private String Name;
    private int CategoryId;
    private String Detail;
    private String Thumbnail;
    private double Price;
    private FoodInformationStatus Status;

    private HashMap<String, String> errors = new HashMap<>();



    public boolean isValid(){
        checkValidate();
        return errors.size() == 0;
    }

    private void checkValidate(){
        //validate data basic
        if(Name == null || Name.length() <= 7){
            errors.put("Name", "The name of the dish cannot be blank and must be more than 7 characters!");
        }
        if (Detail == null || Detail.length() == 0){
            errors.put("Detail", "Please enter detail");
        }
        if (Thumbnail == null || Thumbnail.length() == 0){
            errors.put("Thumbnail", "Please enter thumbnail");
        }
        if (Price <= 0 ){
            errors.put("Price", "Please enter a price greater than 0!");
        }
    }

    public HashMap<String, String> getErrors() {
        return errors;
    }

    public void setErrors(HashMap<String, String> errors) {
        this.errors = errors;
    }

    public void addErrors(String key, String value){
        if(this.errors == null){
            this.errors = new HashMap<>();
        }
        this.errors.put(key, value);
    }

    public List<String> getListErrors(){
        return new ArrayList<>(errors.values());
    }

    @Override
    public String toString() {
        return "FoodInformation{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", CategoryId=" + CategoryId +
                ", Detail='" + Detail + '\'' +
                ", Thumbnail='" + Thumbnail + '\'' +
                ", Price=" + Price +
                ", Status=" + Status +
                '}';
    }

    public FoodInformation() {
        this.Name = "";
        this.Detail="";
        this.Thumbnail="";
        this.Price = 0;
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
        this.Status=FoodInformationStatus.ACTIVE;
    }

    public FoodInformation(String Name, int CategoryId, String Detail, String Thumbnail, double Price) {
        this.Name = Name;
        this.CategoryId = CategoryId;
        this.Detail = Detail;
        this.Thumbnail = Thumbnail;
        this.Price = Price;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int CategoryId) {
        this.CategoryId = CategoryId;
    }

    public String getDetail() {
        return Detail;
    }

    public void setDetail(String Detail) {
        this.Detail = Detail;
    }

    public String getThumbnail() {
        return Thumbnail;
    }

    public void setThumbnail(String Thumbnail) {
        this.Thumbnail = Thumbnail;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public FoodInformationStatus getStatus() {
        return Status;
    }

    public void setStatus(FoodInformationStatus Status) {
        this.Status = Status;
    }
}

package com.example.assignment.entity;

import com.example.assignment.entity.base.BaseEntity;
import com.example.assignment.entity.myenum.CategoriesStatus;

import java.time.LocalDateTime;

public class Categories extends BaseEntity {
    private int Id;
    private String Name;
    private CategoriesStatus Status;

    public Categories() {
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
        this.Status = CategoriesStatus.ACTIVE;
    }

    public Categories(int Id, String Name) {
        this.Id = Id;
        this.Name = Name;
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
        this.Status = CategoriesStatus.ACTIVE;
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

    public CategoriesStatus getStatus() {
        return Status;
    }

    public void setStatus(CategoriesStatus Status) {
        this.Status = Status;
    }
}


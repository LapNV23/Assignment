package com.example.assignment.model;

import com.example.assignment.entity.Categories;
import com.example.assignment.entity.myenum.CategoriesStatus;
import com.example.assignment.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class MySqlCategoriesModel implements CategoriesModel{
    @Override
    public Categories save(Categories obj) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "insert into categories " +
                    "(Name, CreatedAt, UpdatedAt, Status) " +
                    "values " +
                    "(?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, obj.getName());
            preparedStatement.setString(2, obj.getCreatedAt().toString());
            preparedStatement.setString(3, obj.getUpdatedAt().toString());
            preparedStatement.setInt(4, obj.getStatus().getValue());

            System.out.println("Action success!");
            preparedStatement.execute();
            return obj;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Categories> findAll() {
        List<Categories> list = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from categories where Status = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, CategoriesStatus.ACTIVE.getValue());
            System.out.println("Connection success!");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int Id = resultSet.getInt("Id");
                String Name = resultSet.getString("Name");
                LocalDateTime CreatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("CreatedAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime UpdatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("UpdatedAt").toInstant(), ZoneId.systemDefault());
                int intStatus = resultSet.getInt("Status");
                Categories obj = new Categories(Id,Name);
                obj.setCreatedAt(CreatedAt);
                obj.setUpdatedAt(UpdatedAt);
                obj.setStatus(CategoriesStatus.of(intStatus));
                list.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Categories findById(int Id) {
        Categories obj = null;
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from categories where Status = ? and Id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, CategoriesStatus.ACTIVE.getValue());
            preparedStatement.setInt(2,Id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                String Name = resultSet.getString("Name");
                LocalDateTime CreatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("CreatedAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime UpdatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("UpdatedAt").toInstant(), ZoneId.systemDefault());
                int intStatus = resultSet.getInt("Status");
                obj = new Categories(Id,Name);
                obj.setCreatedAt(CreatedAt);
                obj.setUpdatedAt(UpdatedAt);
                obj.setStatus(CategoriesStatus.of(intStatus));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public Categories update(int Id, Categories updateObj) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "update categories " +
                    "set Name = ?,CreatedAt = ?, UpdatedAt = ?, Status = ? where Id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, updateObj.getName());
            preparedStatement.setString(2, updateObj.getCreatedAt().toString());
            preparedStatement.setString(3, updateObj.getUpdatedAt().toString());
            preparedStatement.setInt(4, updateObj.getStatus().getValue());
            preparedStatement.setInt(5, Id);
            preparedStatement.execute();
            System.out.println("Action success!");
            return updateObj;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(int Id) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "update categories " +
                    "set Status = ? where Id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, CategoriesStatus.DELETED.getValue());
            preparedStatement.setInt(2, Id);
            preparedStatement.execute();
            System.out.println("Action success!");

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

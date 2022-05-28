package com.example.assignment.model;

import com.example.assignment.entity.FoodInformation;
import com.example.assignment.entity.myenum.FoodInformationStatus;
import com.example.assignment.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class MySqlFoodInformationModel implements FoodInformationModel{
    @Override
    public FoodInformation save(FoodInformation obj) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "insert into foodinformation" +
                    "(`Name`,CategoryId,Detail,Thumbnail,Price,CreatedAt,UpdatedAt,Status)" +
                    "values " +
                    "(?, ?, ?, ?, ?, ? ,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, obj.getName());
            preparedStatement.setInt(2, obj.getCategoryId());
            preparedStatement.setString(3, obj.getDetail());
            preparedStatement.setString(4, obj.getThumbnail());
            preparedStatement.setDouble(5, obj.getPrice());
            preparedStatement.setString(6, obj.getCreatedAt().toString());
            preparedStatement.setString(7, obj.getUpdatedAt().toString());
            preparedStatement.setInt(8, obj.getStatus().getValue());
//            preparedStatement.execute();
            preparedStatement.execute();
            System.out.println("Action success!");

            return obj;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<FoodInformation> findAll() {
        List<FoodInformation> list = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from foodinformation where Status = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, FoodInformationStatus.ACTIVE.getValue());
            System.out.println("Connection success!");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int Id = resultSet.getInt("Id");
                String Name = resultSet.getString("Name");
                int CategoryId = resultSet.getInt("CategoryId");
                String Detail = resultSet.getString("Detail");
                String Thumbnail = resultSet.getString("Thumbnail");
                double Price = resultSet.getDouble("Price");
                LocalDateTime CreatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("CreatedAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime UpdatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("UpdatedAt").toInstant(), ZoneId.systemDefault());
                int intStatus = resultSet.getInt("Status");
                FoodInformation obj = new FoodInformation(Name, CategoryId, Detail, Thumbnail, Price);
                obj.setId(Id);
                obj.setName(Name);
                obj.setCategoryId(CategoryId);
                obj.setDetail(Detail);
                obj.setThumbnail(Thumbnail);
                obj.setPrice(Price);
                obj.setCreatedAt(CreatedAt);
                obj.setUpdatedAt(UpdatedAt);
                obj.setStatus(FoodInformationStatus.of(intStatus));
                list.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public FoodInformation findById(int Id) {
        FoodInformation obj = null;
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from foodinformation where Status = ? and Id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, FoodInformationStatus.ACTIVE.getValue());
            preparedStatement.setInt(2, Id);
            System.out.println("Connection success!");
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){

                String Name = resultSet.getString("Name");
                int CategoryId = resultSet.getInt("CategoryId");
                String Detail = resultSet.getString("Detail");
                String Thumbnail = resultSet.getString("Thumbnail");
                double Price = resultSet.getDouble("Price");
                LocalDateTime CreatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("CreatedAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime UpdatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("UpdatedAt").toInstant(), ZoneId.systemDefault());
                int intStatus = resultSet.getInt("Status");
                obj = new FoodInformation(Name, CategoryId, Detail, Thumbnail, Price);
                obj.setId(Id);
                obj.setName(Name);
                obj.setCategoryId(CategoryId);
                obj.setDetail(Detail);
                obj.setThumbnail(Thumbnail);
                obj.setPrice(Price);
                obj.setCreatedAt(CreatedAt);
                obj.setUpdatedAt(UpdatedAt);
                obj.setStatus(FoodInformationStatus.of(intStatus));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public FoodInformation update(int Id, FoodInformation updateObj) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "update foodinformation" +
                    "set Name = ?,CategoryId = ?,Detail=?,Thumbnail=?,Price=?,CreatedAt = ?, UpdatedAt = ?, Status = ? where Id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, updateObj.getName());
            preparedStatement.setInt(2, updateObj.getCategoryId());
            preparedStatement.setString(3, updateObj.getDetail());
            preparedStatement.setString(4, updateObj.getThumbnail());
            preparedStatement.setDouble(5, updateObj.getPrice());
            preparedStatement.setString(6, updateObj.getCreatedAt().toString());
            preparedStatement.setString(7, updateObj.getUpdatedAt().toString());
            preparedStatement.setInt(8,updateObj.getStatus().getValue());
            preparedStatement.setInt(9, Id);
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
            String sqlQuery = "update foodinformation " +
                    "set Status = ? where Id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, FoodInformationStatus.DELETED.getValue());
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

package com.example.assignment.entity.myenum;

public enum FoodInformationStatus {
    ACTIVE(1), DEACTIVE(0), DELETED(-1), UNDEFINE(-2);
    private int value;
    FoodInformationStatus(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }

    public static FoodInformationStatus of(int value){
        for (FoodInformationStatus status :
                FoodInformationStatus.values()){
            if (status.getValue() == value){
                return status;
            }
        }
        return FoodInformationStatus.UNDEFINE;
    }
}

package com.example.assignment.entity.myenum;

public enum CategoriesStatus {
    ACTIVE(1), DEACTIVE(0), DELETED(-1), UNDEFINE(-2);
    private int value;
    CategoriesStatus(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static CategoriesStatus of(int value) {
        for (CategoriesStatus status :
                CategoriesStatus.values()) {
            if (status.getValue() == value) {
                return status;
            }
        }
        return CategoriesStatus.UNDEFINE;
    }
}

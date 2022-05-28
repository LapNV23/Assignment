package com.example.assignment.entity.base;

import java.time.LocalDateTime;

public abstract class BaseEntity {
    private LocalDateTime CreatedAt;
    private LocalDateTime UpdatedAt;

    public LocalDateTime getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(LocalDateTime CreatedAt) {
        this.CreatedAt = CreatedAt;
    }

    public LocalDateTime getUpdatedAt() {
        return UpdatedAt;
    }

    public void setUpdatedAt(LocalDateTime UpdatedAt) {
        this.UpdatedAt = UpdatedAt;
    }
}

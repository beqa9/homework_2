package com.example.excel.homewok2.models;

import lombok.Builder;

@Builder
public record UserModel(
        Integer id,
        String email,
        String password,
        String firstName,
        String lastName
) {
}

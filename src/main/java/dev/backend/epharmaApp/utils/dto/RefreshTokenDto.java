package dev.backend.epharmaApp.utils.dto;

import lombok.Data;

@Data
public class RefreshTokenDto {
    private Long userId;
    private String refreshToken;

    // Getters et Setters
}

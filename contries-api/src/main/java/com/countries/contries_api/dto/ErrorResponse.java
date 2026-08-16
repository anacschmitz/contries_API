package com.countries.contries_api.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.Instant;
@Schema(description = "Standard error payload")
public record ErrorResponse(
        @Schema(description = "Timestamp when the error occurred")
        Instant timestamp,

        @Schema(description = "HTTP status code", example = "404")
        int status,

        @Schema(description = "Short error label", example = "Not Found")
        String error,

        @Schema(description = "message for high level understanding", example = "City with id 999 not found")
        String message,

        @Schema(description = "Path of the request that caused the error", example = "/cities/999")
        String path) {

        public static ErrorResponse of(int status, String error, String message, String path) {
                return new ErrorResponse(Instant.now(), status, error, message, path);
        }
}

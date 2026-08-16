package com.countries.contries_api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.domain.Page;

import java.lang.reflect.Type;
import java.util.List;

@Schema(description = "Generic response for the pagination information")
public record PageResponse<T>(
        @Schema(description = "Content of the current page")
        List<T> content,

        @Schema(description = "Current page number (zero-based)", example = "0")
        int page,

        @Schema(description = "Number of itens displayed by page", example = "10")
        int size,

        @Schema(description = "Total number of elements between all pages", example = "100")
        long totalElements,

        @Schema(description = "Total number of pages", example = "10")
        int totalPages,

        @Schema(description = "Last page situation", example = "false")
        boolean last
) {

        public static <T> PageResponse<T> from(Page<T> page) {
                return new PageResponse<>(
                        page.getContent(),
                        page.getNumber(),
                        page.getSize(),
                        page.getTotalElements(),
                        page.getTotalPages(),
                        page.isLast()
                );
        }
}

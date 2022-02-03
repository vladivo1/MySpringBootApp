package com.example.myspringapp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Сущность смартфона")
public class SmartphoneDto {

    @Schema(description = "Бренд смартфона", example = "iPhone")
    private String brand;
    @Schema(description = "Операционная система смартфона", example = "iOS")
    private String os;
    @Schema(description = "Модель смартфона", example = "11 Pro Max")
    private String model;
}

package com.example.messagingapp.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Ответ с ошибкой")
public class ErrorResponceApp {

    @Schema(description = "Сообщение об ошибке",
            example = "Сообщение не найдено")
    private String messageError;
}

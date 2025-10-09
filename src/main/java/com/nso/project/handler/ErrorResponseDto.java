package com.nso.project.handler;

import java.time.LocalDateTime;

public record ErrorResponseDto(

        String message,

        String detailMessage,

        LocalDateTime errorTime
) {
}

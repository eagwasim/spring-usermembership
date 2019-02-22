package com.andela.assessment.membershipapi.usecases.data;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ErrorResponse {
    private LocalDateTime timeStamp;
    private String errorDetails;

    public ErrorResponse(LocalDateTime timeStamp, String errorDetails) {
        this.timeStamp = timeStamp;
        this.errorDetails = errorDetails;
    }
}

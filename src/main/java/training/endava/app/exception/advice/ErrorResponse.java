package training.endava.app.exception.advice;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorResponse {
    @JsonFormat
    private String message;
    @JsonFormat
    private int errorCode;

    ErrorResponse(String message, int errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "message='" + message + '\'' +
                ", errorCode=" + errorCode +
                '}';
    }
}

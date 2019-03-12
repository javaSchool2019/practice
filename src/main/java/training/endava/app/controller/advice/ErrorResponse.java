package training.endava.app.controller.advice;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResponse {
    @JsonProperty
    private int httpStatus;
    @JsonProperty
    private String errorMessage;

    public ErrorResponse(int httpStatus, String errorMessage){
        this.httpStatus = httpStatus;
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "httpStatus: " + httpStatus +
                "errorMessage: " + errorMessage +
                "}";
    }
}

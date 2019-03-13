package training.endava.app.controller.advice;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;

public class ErrorResponse {

    @JsonProperty
    private HttpStatus status;

    @JsonProperty
    private int statusCode;

    @JsonProperty
    private String exceptionMessage;

    public ErrorResponse(HttpStatus status){
        this.status = status;
        this.statusCode = status.value();
        this.exceptionMessage = status.getReasonPhrase();
    }

    public ErrorResponse(HttpStatus status, String exceptionMessage){
        this.status = status;
        this.statusCode = status.value();
        this.exceptionMessage = exceptionMessage;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "status=" + status +
                ", statusCode=" + statusCode +
                ", exceptionMessage='" + exceptionMessage + '\'' +
                '}';
    }

}

package training.endava.app.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;

public class ErrorResponse {

    @JsonProperty
    private HttpStatus status;

    @JsonProperty
    private int statusCode;

    @JsonProperty
    private String exceptionMessage;

    @JsonProperty
    private String whereCameFrom;

    public ErrorResponse(HttpStatus status){
        this.status = status;
        this.statusCode = status.value();
        this.exceptionMessage = status.getReasonPhrase();
    }

    public ErrorResponse(HttpStatus status, String exceptionMessage){
        this.status = status;
        this.statusCode = status.value();
        this.exceptionMessage = exceptionMessage;
        this.whereCameFrom = null;
    }

    public ErrorResponse(HttpStatus status, String exceptionMessage, String whereCameFrom){
        this.status = status;
        this.statusCode = status.value();
        this.exceptionMessage = exceptionMessage;
        this.whereCameFrom = whereCameFrom;
    }

    @Override
    public String toString() {
        String toString = "ErrorResponse{" +
                "status=" + status +
                ", statusCode=" + statusCode +
                ", exceptionMessage='" + exceptionMessage + '\'';
        if(whereCameFrom!=null)
                toString += ", whereCameFrom='" + whereCameFrom + '\'' + '}';
        else{
            toString+=+ '}';
        }
        return toString;
    }
}

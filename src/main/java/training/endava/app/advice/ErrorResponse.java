package training.endava.app.advice;
import com.fasterxml.jackson.annotation.JsonProperty;
public class ErrorResponse {
    @JsonProperty
    private int httpStatus;
    @JsonProperty
    private String specificMessage;
    public ErrorResponse(int httpStatus,String specificMessage){

        this.httpStatus=httpStatus;
        this.specificMessage=specificMessage;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "httpStatus=" + httpStatus +
                ", specificMessage='" + specificMessage + '\'' +
                '}';
    }
}

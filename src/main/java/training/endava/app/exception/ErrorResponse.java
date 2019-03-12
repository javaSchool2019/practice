package training.endava.app.exception;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public class ErrorResponse {

    @JsonProperty
    private String httpmessage;
    @JsonProperty
    private Integer httpstatuscode;

    public ErrorResponse(Integer httpstatuscode, String httpmessage ){
        this.httpmessage = httpmessage;
        this.httpstatuscode = httpstatuscode;
    }

    @JsonValue
    @Override
    public String toString() {
        return "ErrorResponse{" +
                "httpmessage='" + httpmessage + '\'' +
                ", httpstatuscode=" + httpstatuscode +
                '}';
    }
}

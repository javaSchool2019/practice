package training.endava.app.controller.advice;

public class ErrorResponse {
    private int statusCode;
    private String Message;

    public ErrorResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        Message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}

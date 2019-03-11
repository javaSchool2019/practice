package training.endava.app.payload;

public class ApiResponse<T> {
    private T response;

    public ApiResponse(T response) {
        this.response = response;
    }

    public ApiResponse() {}

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }
}

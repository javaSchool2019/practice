package training.endava.skeleton.db;

public class ExceptionLimitedContainer extends RuntimeException {
    public ExceptionLimitedContainer(String messageError)
    {
        super(messageError);
    }
}

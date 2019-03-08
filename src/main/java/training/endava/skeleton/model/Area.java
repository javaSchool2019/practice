package training.endava.skeleton.model;

public enum Area {
    IT(1),
    FINANCE(2);

    private int code;

    Area(int code) {
        this.code = code;
    }

    public int getCode(){
        return code;
    }
}

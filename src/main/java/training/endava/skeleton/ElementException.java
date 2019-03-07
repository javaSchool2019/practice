package training.endava.skeleton;

public class ElementException extends RuntimeException {

    public enum ElementErrors{
        DUPLICATE_ELEMENT(1, "Element already in the database"),
        NULL_ELEMENT(2, "Null elements not allwoed");

        private int id;
        private String description;

        ElementErrors(int id, String description){
            this.id = id;
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public ElementException(){
        super();
    }

    public ElementException(ElementErrors error){
        super(error.getDescription());
    }
}

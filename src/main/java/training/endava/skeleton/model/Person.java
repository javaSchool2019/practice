package training.endava.skeleton.model;

public class Person implements SkeletonObject<Person, Long> {

    private Long id;
    private String name;
    private String phoneNumber;
    private String address;

    public Person(Long id, String name, String phoneNumber, String address) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\''
                ;
    }


}

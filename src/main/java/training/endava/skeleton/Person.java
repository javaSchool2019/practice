package training.endava.skeleton;

public class Person implements SkeletonObject<Person, Integer> {

    private String name;
    private Integer id;
    private String phoneNumber;
    private String address;


    public Person(String name, Integer id, String phoneNumber, String address) {
        this.name = name;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        address = address;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", ID=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", Address='" + address + '\'' +
                '}';
    }
}

package training.endava.skeleton;

public class Person implements SkeletonObject<Person, Integer> {
    private Integer id;
    private String name;
    private String phoneNumber;
    private String address;


    public Person(Integer id,String name, String phoneNumber,String address){

        this.id=id;
        this.name=name;
        this.phoneNumber=phoneNumber;
        this.address=address;
    }
    public String getAddress(){

        return address;
    }
    public Integer getId(){

        return id;
    }
    public String getName(){

        return this.name;
    }

    public String getPhoneNumber(){

        return this.phoneNumber;
    }

    public void setId(Integer id){
    this.id=id;
    }

    public void setName(String Name){
        this.name=Name;

    }
    public void setPhoneNumber(String PhoneNumber){
        this.phoneNumber=PhoneNumber;

    }
    public void setAddress(String Address){

        this.address=Address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "Id=" + id +
                ", Name='" + name + '\'' +
                ", PhoneNumber='" + phoneNumber + '\'' +
                ", Address='" + address + '\'' +
                '}';
    }
}

package training.endava.skeleton;

import com.sun.xml.internal.bind.v2.model.core.ID;

public class Person implements SkeletonObject<Person,Integer> {
    private String name;
    private String emailAddress;
    private String phoneNumber;
    private Integer id;

    public Person(String name, String emailAddress, String phoneNumber, Integer i) {
        this.setName(name);
        this.setEmailAddress(emailAddress);
        this.setPhoneNumber(phoneNumber);
        this.setId(i);
    }

    public Person(String name, String emailAddress, Integer i) {
        this.setName(name);
        this.setEmailAddress(emailAddress);
        this.setId(i);
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    private void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    private void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public String toString() {
        if (phoneNumber == null) {
            return "ID " + this.getId() + "\n" + "\t" +
                    "Person{" +
                    "name='" + this.getName() + '\'' +
                    ", emailAddress='" + this.getEmailAddress() + '\'' +
                    '}';
        }

        return "ID " + this.getId() + "\n" + "\t" +
                "Person{" +
                "name='" + this.getName() + '\'' +
                ", emailAddress='" + this.getEmailAddress() + '\'' +
                ", phoneNumber='" + this.getPhoneNumber() + '\'' +
                '}';
    }
}

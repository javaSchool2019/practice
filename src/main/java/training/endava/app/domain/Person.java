package training.endava.app.domain;

import java.util.Date;

public class Person {

    private Integer id;
    private String name;
    private String prenume;
    private Date birthday;
    private String birthplace;
    private Integer id_address;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public Integer getId_address() {
        return id_address;
    }

    public void setId_address(Integer id_address) {
        this.id_address = id_address;
    }

    public static void ageCalculator(Date d){
        long ms=System.currentTimeMillis()- d.getTime();
        long age=(long)((long)ms/(1000.0*60*60*24*365));
        System.out.println(age);


    }
    /*
        public Person(Integer id, String name, String prenume) {
            this.id = id;
            this.name = name;
            this.prenume = prenume;
        }*/
    public Person(Integer id,String name,Date birthday,String birthplace,Integer id_address){

        this.id=id;
        this.name=name;
        this.birthday=birthday;
        this.birthplace=birthplace;
        this.id_address=id_address;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", prenume='" + prenume + '\'' +
                ", birthday=" + birthday +
                ", birthplace='" + birthplace + '\'' +
                ", id_address=" + id_address +
                '}';
    }
}
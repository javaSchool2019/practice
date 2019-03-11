package training.endava.skeleton.model;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Company {
    private String name;
    private Year foundationYear;
    private Area area;
    private List<Person> personList;

    public Company(String name, Year foundantionYear, Area area, List<Person> personList) {
        this.name = name;
        this.foundationYear = foundantionYear;
        this.area = area;
        this.personList = personList;
    }

    public Company(String name, Year foundationYear, Area area) {
        this(name, foundationYear, area, new ArrayList<>());
    }

    public boolean addPerson(Person person){
        return personList.add(person);
    }

    public boolean deletePerson(Person person){
        return personList.remove(person);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Year getFoundationYear() {
        return foundationYear;
    }

    public void setFoundationYear(Year foundationYear) {
        this.foundationYear = foundationYear;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", foundationYear=" + foundationYear +
                ", area=" + area +
                ", personList=" + personList +
                '}';
    }
}

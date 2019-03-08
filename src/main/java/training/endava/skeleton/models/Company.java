package training.endava.skeleton.models;

import java.time.Year;
import java.util.List;

public class Company {
    private String name;
    private Year foundationYear;
    private List<Person> persons;
    private WorkingArea area;
    private int sharePrice;

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

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public WorkingArea getArea() {
        return area;
    }

    public void setArea(WorkingArea area) {
        this.area = area;
    }

    public Company(String name, Year foundationYear, List<Person> persons, WorkingArea area, int sharePrice) {
        this.name = name;
        this.foundationYear = foundationYear;
        this.persons = persons;
        this.area = area;
        this.sharePrice = sharePrice;
    }

    public Company() {
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", foundationYear=" + foundationYear +
                ", persons=" + persons +
                ", area=" + area +
                '}';
    }

    public int getSharePrice() {
        return sharePrice;
    }

    public void setSharePrice(int sharePrice) {
        this.sharePrice = sharePrice;
    }
}

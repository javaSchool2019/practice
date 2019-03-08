package training.endava.skeleton.Classes;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private String name;
    private Integer foundationYear;
    private List<Person> personList;
    public CompanyArea companyArea;


    public Company(String name, Integer foundationYear, CompanyArea companyArea) {
        this.name = name;
        this.foundationYear = foundationYear;
        this.companyArea = companyArea;
        this.personList = new ArrayList<>();
    }

    public Company(String name, Integer foundationYear, List<Person> personList, CompanyArea companyArea) {
        this.name = name;
        this.foundationYear = foundationYear;
        this.personList = personList;
        this.companyArea = companyArea;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFoundationYear() {
        return foundationYear;
    }

    public void setFoundationYear(Integer foundationYear) {
        this.foundationYear = foundationYear;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public void addPerson(Person person){
        this.personList.add(person);
        person.setCompany(this);
    }
    public CompanyArea getCompanyArea() {
        return companyArea;
    }

    public void setCompanyArea(CompanyArea companyArea) {
        this.companyArea = companyArea;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", foundationYear=" + foundationYear +
                ", companyArea=" + companyArea +
                '}';
    }
}

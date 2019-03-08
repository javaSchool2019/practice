package training.endava.skeleton;

import java.util.List;

enum CompanyArea
{
    IT, FINANCE, QA;
}

public class Company {

    //name, the foundation year, a list of persons,
    // an enum specifing the company area(IT, FINANCE..) and other attributes at your liking.

    private String name;
    private Integer foundationYear;
    private List<Person> persons;
    private int companyCapacity;

    private CompanyArea companyArea;

    public int getCompanyCapacity() {
        return companyCapacity;
    }

    public void setCompanyCapacity(int companyCapacity) {
        this.companyCapacity = companyCapacity;
    }

    public Company(String name, Integer foundationYear, List<Person> persons, int companyCapacity, CompanyArea companyArea) {
        this.name = name;
        this.foundationYear = foundationYear;
        this.persons = persons;
        this.companyCapacity = companyCapacity;
        this.companyArea = companyArea;
    }

//    public Company(String name, Integer foundationYear, List<Person> persons, CompanyArea companyArea) {
//        this.name = name;
//        this.foundationYear = foundationYear;
//        this.persons = persons;
//        this.companyArea = companyArea;
//    }

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

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public CompanyArea getCompanyArea() {
        return companyArea;
    }

    public void setCompanyArea(CompanyArea companyArea) {
        this.companyArea = companyArea;
    }

    public void addPerson(Person person)
    {
        persons.add(person);
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", foundationYear=" + foundationYear +
                ", persons=" + persons +
                ", companyCapacity=" + companyCapacity +
                ", companyArea=" + companyArea +
                '}';
    }
}

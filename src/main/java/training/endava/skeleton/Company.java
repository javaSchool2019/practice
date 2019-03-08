package training.endava.skeleton;

import java.time.Year;
import java.util.List;

public class Company {
    private String name;
    private List<Person> employees;
    private int foundationYear;
    private CompanyArea area;

    public Company(String name, List<Person> employees, int foundationYear, CompanyArea area){
        this.name = name;
        this.employees = employees;
        if(foundationYear > 1800 && foundationYear < 2018)
             this.foundationYear = foundationYear;
        else
            throw new InvalidYearException();
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Person> employees) {
        this.employees = employees;
    }

    public int getFoundationYear() {
        return foundationYear;
    }

    public void setFoundationYear(int foundationYear) {
        this.foundationYear = foundationYear;
    }

    public CompanyArea getArea() {
        return area;
    }

    public void setArea(CompanyArea area) {
        this.area = area;
    }
}

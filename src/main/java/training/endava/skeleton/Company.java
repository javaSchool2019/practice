package training.endava.skeleton;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Company {
    private List<Person> employeeList = new ArrayList<>();

    public enum Departments {
        IT, FINANCE, TRANSPORT;
    }

    private String companyArea;
    private Year foundationYear;
    private String name;

    public Company(String name, List<Person> employeeList, Departments companyArea, Year foundationYear) {
        this.companyArea = companyArea.name();
        this.employeeList = employeeList;
        this.foundationYear = foundationYear;
        this.name = name;
    }

    public void addEmployee(Person p) {
        this.employeeList.add(p);
    }

    public List<Person> getEmployeeList() {
        return employeeList;
    }

    public String getCompanyArea() {
        return companyArea;
    }

    public void setCompanyArea(String companyArea) {
        this.companyArea = companyArea;
    }

    public Year getFoundationYear() {
        return foundationYear;
    }

    public void setFoundationYear(Year foundationYear) {
        this.foundationYear = foundationYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                '}';
    }
}

package training.endava.skeleton;

import java.util.*;



public class Company {
    private String name;
    private Integer year;
    public List<Person> list = new ArrayList<>();
    CompanyArea compArea;

    public Company(String name, int year, List<Person> list, CompanyArea compArea) {
        this.name = name;
        this.year = year;
        this.list = list;
        this.compArea = compArea;
    }

    public Company() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Person> getList() {
        return list;
    }

    public void setList(List<Person> list) {
        this.list = list;
    }

    public CompanyArea getCompArea() {
        return compArea;
    }

    public void setCompArea(CompanyArea compArea) {
        this.compArea = compArea;
    }
}

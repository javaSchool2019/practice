package training.endava.skeleton.model;

import java.util.List;

public class Company {
    private String name;
    private Integer year;
    private List<Person> personList;
    private CompanyArea companyArea;
    private Integer profit;


    public Company(String name, Integer year, List<Person> personList, CompanyArea companyArea, Integer profit) {
        this.name = name;
        this.year = year;
        this.personList = personList;
        this.companyArea = companyArea;
        this.profit = profit;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public CompanyArea getCompanyArea() {
        return companyArea;
    }

    public void setCompanyArea(CompanyArea companyArea) {
        this.companyArea = companyArea;
    }

    public Integer getProfit() {
        return profit;
    }

    public void setProfit(Integer profit) {
        this.profit = profit;
    }


    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", personList=" + personList +
                ", companyArea=" + companyArea +
                ", profit=" + profit +
                '}';
    }


}

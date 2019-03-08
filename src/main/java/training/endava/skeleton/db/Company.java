package training.endava.skeleton.db;

import java.util.ArrayList;
import java.util.List;



public class Company {
    //enum with company areas
    public enum compArea { IT, FINANCE
    }

    //name, the foundation year, a list of persons,
    // an enum specifing the company area(IT, FINANCE..) and other attributes at your liking
    String name;
    Integer fYear;
    private List<Person> listOfPers = new ArrayList<>();
    compArea companyArea;


    public Company(String name, Integer fYear, List<Person> listOfPers, compArea companyArea) {
        this.name = name;
        this.fYear = fYear;
        this.listOfPers = listOfPers;
        this.companyArea = companyArea;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getfYear() {
        return fYear;
    }

    public void setfYear(Integer fYear) {
        this.fYear = fYear;
    }

    public List<Person> getListOfPers() {
      return listOfPers;
    }

    public void setListOfPers(List<Person> listOfPers) {
      this.listOfPers = listOfPers;
   }

    public compArea getCompanyArea() {
        return companyArea;
    }

    public void setCompanyArea(compArea companyArea) {
        this.companyArea = companyArea;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", fYear=" + fYear +
                ", listOfPers=" + listOfPers +
                ", companyArea=" + companyArea +
                '}';
    }
}

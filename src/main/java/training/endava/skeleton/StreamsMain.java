package training.endava.skeleton;

import training.endava.skeleton.models.Company;
import training.endava.skeleton.models.Person;
import training.endava.skeleton.models.WorkingArea;

import java.time.Year;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamsMain {

    public static List<Person> createDummyPersonList(int start, int number) {
        List<Person> persons = new ArrayList<>();
        int count = 0;
        while (count <= number) {
            Person person = new Person(start, "Name" + start, "076123456" + start % 10, "Address" + start);
            persons.add(person);
            count++;
            start++;
        }
        return persons;
    }

    public static List<Company> createDummyCompanyList() {
        List<Company> companies = new ArrayList<>();
        Company c1 = new Company("Endava", Year.of(2000), createDummyPersonList(1, 4), WorkingArea.IT, 20);
        Company c2 = new Company("Amazon", Year.of(1990), createDummyPersonList(6, 4), WorkingArea.IT, 1680);
        Company c3 = new Company("Unicredit", Year.of(2003), createDummyPersonList(11, 4), WorkingArea.BANKKING, 10);
        Company c4 = new Company("Centric", Year.of(2008), createDummyPersonList(16, 4), WorkingArea.IT, 30);
        Company c5 = new Company("Starbucks", Year.of(2001), createDummyPersonList(21, 3), WorkingArea.SERVICES, 180);
        return Arrays.asList(c1, c2, c3, c4, c5);
    }

    public static void listCompanyNames(List<Company> companies) {
        System.out.println("Companies names:");
        companies.stream().forEach(c -> System.out.println("--> " + c.getName()));
    }

    public static void computeAverageSharePrice(List<Company> companies) {
        System.out.print("Average share price: ");
        companies.stream().mapToInt(Company::getSharePrice).average().ifPresent(System.out::println);
    }

    public static Company findOldestCompany(List<Company> companies) {
        return companies.stream().sorted(Comparator.comparing(Company::getFoundationYear)).findFirst().orElse(new Company());
    }

    public static int countPersons(List<Company> companies) {
        return companies.stream().map(c -> c.getPersons().size()).reduce((a, b) -> a + b).orElse(0);
    }

    public static Person createHugePerson(List<Company> companies) {
        return companies.stream()
                .map(Company::getPersons)
                .flatMap(List::stream)
                .reduce(new Person(""), (a, b) -> {
                    a.setName(a.getName() + b.getName());
                    return a;
                });
    }

    public static void displayUniquePersons(List<Company> companies) {
        companies.stream().map(Company::getPersons).flatMap(List::stream).distinct().forEach(System.out::println);
    }

    public static String customNameCollector(List<Person> persons) {
        Collector<Person, StringJoiner, String> nameCollector = Collector.of(
                () -> new StringJoiner("_", "Names: ", " "),
                (supp, person) -> supp.add(person.getName().toLowerCase()),
                StringJoiner::merge,
                StringJoiner::toString
        );
        return persons.stream().collect(nameCollector);
    }

    public static void computingWithSequentialStream(List<Person> persons) {
        long start = System.currentTimeMillis();
        List<Person> personList = persons.stream().filter(p -> p.getName().endsWith("1")).collect(Collectors.toList());
        long end = System.currentTimeMillis();
        System.out.println("Took " + (end - start) + "ms for sequential stream to perform");
    }

    public static void computingWithParallelStream(List<Person> persons) {
        long start = System.currentTimeMillis();
        List<Person> personList = persons.parallelStream().filter(p -> p.getName().endsWith("1")).collect(Collectors.toList());
        long end = System.currentTimeMillis();
        System.out.println("Took " + (end - start) + "ms for parallel stream to perform");
    }

    public static void main(String[] args) {
        List<Company> companies = createDummyCompanyList();
        listCompanyNames(companies);
        computeAverageSharePrice(companies);
        System.out.println("Oldest company: " + findOldestCompany(companies).getName());
        System.out.println("Persons count " + countPersons(companies));
        createHugePerson(companies);
        displayUniquePersons(companies);
        System.out.println("Custom name collector -> " + customNameCollector(companies.get(0).getPersons()));

        List<Person> hugePersonList = createDummyPersonList(1, 3000000);
        computingWithParallelStream(hugePersonList);
        computingWithSequentialStream(hugePersonList);

    }
}

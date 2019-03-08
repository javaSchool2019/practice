package training.endava.skeleton;

import jdk.internal.dynalink.linker.ConversionComparator;

import java.time.Duration;
import java.time.Instant;
import java.time.Year;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SteamsApp {
    public static void main(String[] args) {
        Person p1 = new Person(UUID.randomUUID(), "Popescu", "01234556789", "Iasi");
        Person p2 = new Person(UUID.randomUUID(), "Ionescu", "01234556789", "Iasi");
        Person p3 = new Person(UUID.randomUUID(), "Escu", "01234556789", "Iasi");
        Person p4 = new Person(UUID.randomUUID(), "Liliescu", "01234556789", "Iasi");
        Person p5 = new Person(UUID.randomUUID(), "Pop", "01234556789", "Iasi");
        List<Person> persons1 = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5));

        Person p6 = new Person(UUID.randomUUID(), "Lincescu", "01234556789", "Iasi");
        Person p7 = new Person(UUID.randomUUID(), "Liliescu", "01234556789", "Iasi");
        Person p8 = new Person(UUID.randomUUID(), "Oprescu", "01234556789", "Iasi");
        List<Person> persons2 = new ArrayList<>(Arrays.asList(p6, p7, p8));

        Company c1 = new Company("Endava", persons1, 1992, CompanyArea.IT);
        Company c2 = new Company("Regina Maria", persons2, 1990, CompanyArea.HEALTH);
        List<Company> companies = new ArrayList<>(Arrays.asList(c1, c2));

        companies.stream()
                .map(Company::getName)
                .forEach(System.out::println);
        //I know it would be more efficient to do the filtering first, but...
        companies.stream()
                .mapToInt(Company::getFoundationYear)
                .filter(year -> year > 1990)
                .forEach(System.out::println);

        companies.stream()
                .min(Comparator.comparingInt(Company::getFoundationYear))
                .ifPresent(System.out::println);

        companies.stream()
                .mapToInt(company -> company.getEmployees().size())
                .reduce((size1, size2) -> size1 + size2)
                .ifPresent(System.out::println);

        Person superPerson = persons1.stream().reduce(new Person(UUID.randomUUID(), "", "0000000", "Iasi"),  (person1, person2) -> {person1.setName(person1.getName() + person2.getName()); return person1;});
        System.out.println(superPerson);
        companies.stream().map(Company::getEmployees).flatMap(List::stream).forEach(System.out::println);

        persons1.stream().distinct().forEach(System.out::println);

        Collector<Person, StringJoiner, String> nameAndPhoneCollector = Collector.of(
                () -> new StringJoiner(" ----- "),
                (supp, person) -> supp.add(person.getName() + ":" + person.getPhoneNumber()),
                StringJoiner::merge,
                StringJoiner::toString
        );

        String collectedString = persons1.stream().collect(nameAndPhoneCollector);
        System.out.println(collectedString);

        IntStream intStream = IntStream.generate(() -> new Random().nextInt(20000));
        Instant start = Instant.now();
        OptionalDouble doubleParallel = intStream.parallel().limit(100000000).filter(x1 -> x1 % 3 == 0).average();
        Instant finish = Instant.now();
        long parallelDuration = Duration.between(start, finish).toMillis();

        IntStream intStream2 = IntStream.generate(() -> new Random().nextInt(20000));
        start = Instant.now();
        OptionalDouble doubleSimple = intStream2.limit(100000000).filter(x1 -> x1 % 3 == 0).average();
        finish = Instant.now();
        long simpleDuration = Duration.between(start, finish).toMillis();
        System.out.println(parallelDuration - simpleDuration);
    }
}

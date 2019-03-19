package training.endava.playground.optionals;

import java.util.Optional;

public class TheWhy {

    public static void main(String ... args) {
        Address address = new Address();
        School school = new School();
        Student student = new Student();

        System.out.println(checkCountrySafe(student, "Romania"));

        school.setAddress(address);
        student.setSchool(school);

//        System.out.println(checkCountry(student, "Romania"));

        address.setCountry("Spain");
        System.out.println(checkCountryOptionalBase(student, "Spain"));

        System.out.println(checkCountryOptionalBase(student, "Spain"));
    }

    public static boolean checkCountry(Student student, String country) {
        return student.getSchool().getAddress().getCountry().equals(country);
    }

    public static boolean checkCountrySafe(Student student, String country) {
        if (student != null && student.getSchool() != null && student.getSchool().getAddress() != null && student.getSchool().getAddress().getCountry() != null) {
            return student.getSchool().getAddress().getCountry().equals(country);
        }

        return false;
    }

    public static boolean checkCountryOptionalBase(Student student, String country) {
        // Optional o = (value== null) ? Optional.empty(): Optional.of(value);
        if (student != null) {
            Optional<School> schoolOptional = Optional.ofNullable(student.getSchool());
            if (schoolOptional.isPresent()) {
                School school = schoolOptional.get();
                Optional<Address> addressOptional = Optional.ofNullable(school.getAddress());

                if (addressOptional.isPresent()) {
                    Address address = addressOptional.get();
                    Optional<String> addressCountryOptional = Optional.ofNullable(address.getCountry());

                    if (addressCountryOptional.isPresent()) {
                        String addressCountry = addressCountryOptional.get();

                        return addressCountry.equals(country);
                    }
                }
            }
        }

        return false;
    }

    public static boolean checkCountryOptionalGetter(Student student, String country) {
        return Optional.ofNullable(student)
                .orElse(new Student())
                    .getSchoolOptional()
                    .getAdressOptional()
                    .getCountryOptional()
                        .equals(country);
    }

    public static boolean checkCountryOptionalMap(Student student, String country) {
        return Optional.ofNullable(student)
                .map(Student::getSchool)
                .map(school -> school.getAddress())
                .map(address -> address.getCountry())
                .map(addressCountry -> addressCountry.equals(country))
                .orElse(false);
    }

    public static boolean checkCountryOptionalFlatMap(Student student, String country) {
        return Optional.ofNullable(Optional.ofNullable(student))
                .flatMap(student1 -> student1.map(Student::getSchool))
                .map(school -> school.getAddress())
                .map(address -> address.getCountry())
                .map(addressCountry -> addressCountry.equals(country))
                .orElse(false);

    }


}

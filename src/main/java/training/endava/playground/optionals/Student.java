package training.endava.playground.optionals;

import java.util.Optional;

public class Student {
    private School school;

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public School getSchoolOptional() {
        return Optional.ofNullable(school).orElse(new School());
    }
}

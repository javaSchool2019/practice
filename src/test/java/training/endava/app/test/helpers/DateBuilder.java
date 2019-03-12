package training.endava.app.test.helpers;

import java.util.Calendar;
import java.util.Date;

public class DateBuilder {

    private int numberOfYears;
    private int numberOfDays;
    private int numberOfMonths;

    public DateBuilder addYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
        return this;
    }

    public DateBuilder addMonths(int numberOfMonths) {
        this.numberOfMonths = numberOfMonths;
        return this;
    }

    public DateBuilder adDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
        return this;
    }

    public Date build() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, numberOfDays);
        calendar.add(Calendar.MONTH, numberOfMonths);
        calendar.add(Calendar.YEAR, numberOfYears);
        return calendar.getTime();
    }
}

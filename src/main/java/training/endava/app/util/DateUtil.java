package training.endava.app.util;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static java.util.Calendar.DATE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;

public class DateUtil {

    public static int getDiffYears(Date startDate, Date endDate) {
        Calendar start = getCalendar(startDate);
        Calendar end = getCalendar(endDate);
        int delta = end.get(YEAR) - start.get(YEAR);
        if (start.get(MONTH) > end.get(MONTH) ||
                (start.get(MONTH) == end.get(MONTH) && start.get(DATE) > end.get(DATE))) {
            delta--;
        }
        return delta;
    }

    private static Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }
}

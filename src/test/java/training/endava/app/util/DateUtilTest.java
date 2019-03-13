package training.endava.app.util;

import org.junit.Test;
import training.endava.app.test.helpers.DateBuilder;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Tasks:
 * * add some more tests (1-2)
 * * then move existing tests to parameterized tests
 * * add some more tests if necessary
 */
public class DateUtilTest {

    @Test
    public void shouldReturnNumberOfYearsFor() {
        Date startDate = new DateBuilder()
                .addYears(-10)
                .build();

        Date endDate = new DateBuilder()
                .addYears(-9)
                .addMonths(1)
                .build();

        int diffYears = DateUtil.getDiffYears(startDate, endDate);
        assertEquals(1, diffYears);
    }
}

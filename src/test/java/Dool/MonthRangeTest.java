package Dool;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MonthRangeTest {
    @Test
    public void testIncorrectMonthRange() {

        MonthsRange mr = new MonthsRange();

        boolean answer = mr.checkRangeMonths(45,12,1998);

        assertEquals(false, answer);

    }

    @Test
    public void testCorrectMonthRange() {

        MonthsRange mr = new MonthsRange();

        boolean answer = mr.checkRangeMonths(29,02,2016);

        assertEquals(true, answer);

    }
}

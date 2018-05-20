package Dool;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DaysCalculatorTest {

    @Test
    public void testDatesDifferentYears() {

        int[] startDate = new int[]{3, 1,1989};
        int[] endDate = new int[]{3, 8, 1983};

        DaysCalculator dc = new DaysCalculator(startDate, endDate);

        int theResult = dc.calculateTheResult();
        assertEquals(1979, theResult);

    }
    @Test
    public void testDatesDifferentMonths() {
        int[] startDate = new int[]{4, 7,1984};
        int[] endDate = new int[]{25, 12, 1984};

        DaysCalculator dc = new DaysCalculator(startDate, endDate);

        int theResult = dc.calculateTheResult();
        assertEquals(173, theResult);

    }
    @Test
    public void testDatesDifferentDays() {
        int[] startDate = new int[]{2, 6,1983};
        int[] endDate = new int[]{22, 6, 1983};

        DaysCalculator dc = new DaysCalculator(startDate, endDate);

        int theResult = dc.calculateTheResult();
        assertEquals(19, theResult);

    }


}

package Dool;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

public class SomeTest {
    @Test

    public void testAdd() {
//        int[] startDate = new int[]{03,01,1989}};
////        int[] endDate = new int[]{03,08,1983}};

        LeapYear ly = new LeapYear();

        boolean answer = ly.leapYear(1997);

        assertEquals(false, answer);

    }


}

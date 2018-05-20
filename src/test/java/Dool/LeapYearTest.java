package Dool;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LeapYearTest {

    @Test
    public void testLeap1997() {

        LeapYear ly = new LeapYear();

        boolean answer = ly.leapYear(1997);

        assertEquals(false, answer);

    }
    @Test
    public void testLeap1998() {

        LeapYear ly = new LeapYear();

        boolean answer = ly.leapYear(1998);

        assertEquals(false, answer);

    }
    @Test
    public void testLeap1999() {

        LeapYear ly = new LeapYear();

        boolean answer = ly.leapYear(1999);

        assertEquals(false, answer);

    }

    @Test
    public void testLeap2000() {

        LeapYear ly = new LeapYear();

        boolean answer = ly.leapYear(2000);

        assertEquals(true, answer);

    }

    @Test
    public void testLeap2001() {

        LeapYear ly = new LeapYear();

        boolean answer = ly.leapYear(2001);

        assertEquals(false, answer);

    }

    @Test
    public void testLeap2002() {

        LeapYear ly = new LeapYear();

        boolean answer = ly.leapYear(2002);

        assertEquals(false, answer);

    }
}

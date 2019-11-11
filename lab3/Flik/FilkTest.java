import static org.junit.Assert.*;
import org.junit.Test;

public class FilkTest {
    @Test
    public void testIsSameNumber() {
        assertEquals(true, Flik.isSameNumber(129, 129));
        assertEquals(true, Flik.isSameNumber(125, 125));
        assertEquals(true, Flik.isSameNumber(500, 500));
    }

    /* Run the unit tests in this file. */
    public static void main(String... args) {
        jh61b.junit.TestRunner.runTests("all", FilkTest.class);
    }
}

package psp1;

import static org.junit.Assert.*;
import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class AppTest {
    private Counter locCounter;

    @Before
    public void setUp() {
        locCounter = new Counter();
    }

    @Test
    public void testCountLOC() throws IOException {
        File file = new File("/home/acacio/Desktop/EngenhariaDeSoftware2/psp1/src/main/java/psp1");
        locCounter.countLOC(file);

        assertEquals(117, locCounter.getClassLines());
        assertEquals(2, locCounter.getClassCount());
        assertEquals(10, locCounter.getMethodCount());
        assertEquals(117, locCounter.getClassLines());
    }
}

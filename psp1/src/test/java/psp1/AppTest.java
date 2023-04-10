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
        File file = new File("/home/acacio/Desktop/EngenhariaDeSoftware2/psp0/src/main/java/psp0/App.java");
        locCounter.countLOC(file);

        assertEquals(37, locCounter.getClassLines());
        assertEquals(0, locCounter.getClassCount());
        assertEquals(2, locCounter.getMethodCount());
        assertEquals(37, locCounter.getClassLines());
        assertEquals(0, locCounter.getMethodLines());
    }
}

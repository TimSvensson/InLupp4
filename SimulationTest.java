import org.junit.*;
import junit.framework.TestCase;
import java.util.ArrayList;

/**
 * A JUnit test class
 */
public class SimulationTest extends TestCase {
    
    @Before
    protected void setUp() {

    }

    @Test
    public void test_Simulation() {
	Simulation s = new Simulation(1, 5, 100, 10);
	for (int i = 0; i < 100; i++) {
	    try {
	    s.step();
	    } catch (RuntimeException e) {
		fail("Something caused a runtime exception.");
	    }
	}
    }
}

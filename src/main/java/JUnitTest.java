import static org.junit.Assert.*;
import org.junit.*;

public class JUnitTest {

    private static Polynomial poly1;
    private static Polynomial poly2;
    private static Polynomial result;
    private static int testExecuted = 0;
    private static int testSuccess = 0;

    public JUnitTest()
    {

    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        poly1 = new Polynomial();
        poly2 = new Polynomial();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("S-au executat " + testExecuted + " teste din care "+ testSuccess + " au avut succes!");
    }

    @Before
    public void setUp() throws Exception {

        testExecuted++;
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testAddition() {
        poly1 = new Polynomial("2x^3+2x+1");
        poly2 = new Polynomial("4x^3-3x^2");
        result = poly1.add(poly2);
        String res = result.toString();
        assertNotNull(res);
        assertEquals(res,"6x^3-3x^2+2x+1");
        testSuccess++;
    }

    @Test
    public void testSubtract() {
        poly1 = new Polynomial("2x^3+2x+1");
        poly2 = new Polynomial("4x^3-3x^2");
        result = poly1.subtract(poly2);
        String res = result.toString();
        assertNotNull(res);
        assertEquals(res,"-2x^3+3x^2+2x+1");
        testSuccess++;
    }

    @Test
    public void testMultiply() {
        poly1 = new Polynomial("2x^3+2x+1");
        poly2 = new Polynomial("4x^3-3x^2");
        result = poly1.product(poly2);
        String res = result.toString();
        assertNotNull(res);
        assertEquals(res,"8x^6-6x^5+8x^4-2x^3-3x^2");
        testSuccess++;
    }

    @Test
    public void testDerivative() {
        poly1 = new Polynomial("2x^3+2x+1");
        result = poly1.derivative();
        String res = result.toString();
        assertNotNull(res);
        assertEquals(res,"6x^2+2");
        testSuccess++;
    }

    @Test
    public void testIntegration() {
        poly1 = new Polynomial("2x^3+2x+1");
        result = poly1.integration();
        String res = result.toString();
        assertNotNull(res);
        assertEquals(res,"0.5x^4+x^2+x");
        testSuccess++;
    }
}

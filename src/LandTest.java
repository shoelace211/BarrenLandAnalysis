import static org.junit.Assert.*;

/**
 * jUnit test class
 * @author Ashley Schuelein
 */
public class LandTest {

    Land myLand;
    String input, result;

    @org.junit.Test
    public void calcFertileLand() {

        String input[] = {"0 292 399 307"};
        String result = new String("116800 116800");
        myLand = new Land();
        myLand.readInput(input);
        myLand.clearBarren();
        myLand.setBarren();
        myLand.calcFertileLand();
        assertEquals(result, myLand.printResults());
    }

    @org.junit.Test
    public void calcFertileLand2() {
        String input2 [] = {"48 192 351 207", "48 392 351 407", "120 52 135 547", "260 52 275 547"};
        String result2 = new String ("22816 192608");
        myLand = new Land();
        myLand.readInput(input2);
        myLand.clearBarren();
        myLand.setBarren();
        myLand.calcFertileLand();
        assertEquals(result2, myLand.printResults());
    }
}
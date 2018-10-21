import static org.junit.Assert.*;

/**
 * jUnit test class
 * @author Ashley Schuelein
 */
public class LandTest {

    Land myLand;

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
        String input [] = {"48 192 351 207", "48 392 351 407", "120 52 135 547", "260 52 275 547"};
        String result = new String ("22816 192608");
        myLand = new Land();
        myLand.readInput(input);
        myLand.clearBarren();
        myLand.setBarren();
        myLand.calcFertileLand();
        assertEquals(result, myLand.printResults());
    }

    @org.junit.Test
    public void calcFertileLand3() {

        String input[] = {"0 0 399 599"};
        String result = new String("");
        myLand = new Land();
        myLand.readInput(input);
        myLand.clearBarren();
        myLand.setBarren();
        myLand.calcFertileLand();
        assertEquals(result, myLand.printResults());
    }

    @org.junit.Test
    public void calcFertileLand4() {

        String input[] = {"0 0 0 0"};
        String result = new String("239999");
        myLand = new Land();
        myLand.readInput(input);
        myLand.clearBarren();
        myLand.setBarren();
        myLand.calcFertileLand();
        assertEquals(result, myLand.printResults());
    }

    @org.junit.Test(expected = RuntimeException.class)
    public void calcFertileLand5() {

        String input[] = {""};
        String result = new String("<error> Not enough coordinates in set.");
        myLand = new Land();
        myLand.readInput(input);
        myLand.clearBarren();
        myLand.setBarren();
        myLand.calcFertileLand();
    }

    @org.junit.Test
    public void calcFertileLand6() {
        String input [] = {"100 192 351 230", "48 392 351 407", "90 52 235 447", "300 152 175 307"};
        String result = new String ("175132");
        myLand = new Land();
        myLand.readInput(input);
        myLand.clearBarren();
        myLand.setBarren();
        myLand.calcFertileLand();
        assertEquals(result, myLand.printResults());
    }

    @org.junit.Test
    public void calcFertileLand7() {
        String input [] = {"108 192 211 117", "48 292 300 501", "220 152 335 547", "260 52 275 547"};
        String result = new String ("156344");
        myLand = new Land();
        myLand.readInput(input);
        myLand.clearBarren();
        myLand.setBarren();
        myLand.calcFertileLand();
        assertEquals(result, myLand.printResults());
    }

    @org.junit.Test
    public void calcFertileLand8() {
        String input [] = {"0 192 399 207"};
        String result = new String ("76800 156800");
        myLand = new Land();
        myLand.readInput(input);
        myLand.clearBarren();
        myLand.setBarren();
        myLand.calcFertileLand();
        assertEquals(result, myLand.printResults());
    }
}
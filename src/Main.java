/**
 * Class for running land analysis
 * @author Ashley Schuelein
 */
public class Main {

    public static Land myLand;

    public static void main(String[] args) {
        String input = new String("{0 292 399 307}");
        myLand = new Land();
        myLand.readInput(input);
        myLand.clearBarren();
        myLand.setBarren();
        myLand.calcFertileLand();
        System.out.println(myLand.printResults());
    }
}

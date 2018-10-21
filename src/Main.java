import java.io.BufferedWriter;
import java.io.FileWriter;
/**
 * Class for running land analysis
 * @author Ashley Schuelein
 */
public class Main {

    public static Land myLand;

    /**
     * Prints out a fail message if there is a failure
     * @param errorMessage the message to be printed
     */
    public static void fail(String errorMessage)
    {
        System.out.println("<error> " + errorMessage);
    }

    public static void main(String[] args) throws Exception {
        String STDIN [] = {"48 192 351 207", "48 392 351 407", "120 52 135 547", "260 52 275 547"};
                //"{0 292 399 307}";
        myLand = new Land();
        myLand.userSTDIN("C:\\Users\\Ashley Schuelein\\LandAnalysis\\STDIN.txt");
        //myLand.readInput(STDIN);
        myLand.clearBarren();
        myLand.setBarren();
        myLand.calcFertileLand();
        System.out.println(myLand.printResults());

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Ashley Schuelein\\LandAnalysis\\STDOUT.txt"));
            writer.append("Fertile Land Output\n");
            writer.append(myLand.printResults());
            writer.append("\n");
            writer.close();
        } catch (Exception e) {
            fail("Couldn't print to the file.");
        }
    }
}

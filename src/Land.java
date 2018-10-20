import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Class containing land analysis methods
 * @author Ashley Schuelein
 */
public class Land {

    private final int length = 400;
    private final int width = 600;
    private LinkedList<Integer []> allLand;
    private LinkedList<Integer []> queue;
    private HashMap<Integer, Integer> sqMetersMap;
    private int barrenRec [] [];

    /**
     * Constructor
     */
    public Land() {
        allLand = new LinkedList<Integer []>();
        queue = new LinkedList<Integer []>();
        sqMetersMap = new HashMap<Integer, Integer>();
        barrenRec = new int [length][width];
    }

    /**
     * Prints out a fail message if the program fails
     */
    public void fail(String errorMessage) throws RuntimeException
    {
        System.out.println("<error> " + errorMessage);
        throw new java.lang.RuntimeException("failed");
    }

    /**
     * User writes in input and input string is passed to processing method
     * @throws Exception
     */
    public void userSTDIN() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter barren rectangle coordinates: " );
        String input = reader.readLine();
        readInput(input);
    }

    /**
     * Reads user input and places rectangles in linked list
     * @param input, user input of barren land coordinates
     */
    public void readInput(String input) {
        String parts [] = input.split(",");
        for(String s : parts) {
            if(!s.isEmpty()) {
                String points [] = s.split(" ");
                if(points.length < 4) {
                    fail("Not enough coordinates in set.");
                }
                if(Integer.parseInt(points[0]) >= 0 && Integer.parseInt(points[1]) >= 0 &&
                        Integer.parseInt(points[2]) >= 0 && Integer.parseInt(points[3]) >= 0 &&
                        Integer.parseInt(points[0]) < 400 && Integer.parseInt(points[1]) < 600 &&
                        Integer.parseInt(points[2]) < 400 && Integer.parseInt(points[3]) < 600) {
                    Integer temp [] = {Integer.parseInt(points[0]), Integer.parseInt(points[1]),
                            Integer.parseInt(points[2]), Integer.parseInt(points[3])};
                    allLand.add(temp);
                } else
                    fail("Coordinates out of bounds");
            }
        }
    }
}

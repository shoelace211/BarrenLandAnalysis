import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Class containing land analysis methods
 * @author Ashley Schuelein
 */
public class Land {

    private final int length = 400;
    private final int width = 600;
    private LinkedList<Integer[]> allLand;
    private LinkedList<Integer[]> queue;
    private HashMap<Integer, Integer> sqMetersMap;
    private int barrenRec[][];

    /**
     * Constructor
     */
    public Land() {
        allLand = new LinkedList<Integer[]>();
        queue = new LinkedList<Integer[]>();
        sqMetersMap = new HashMap<Integer, Integer>();
        barrenRec = new int [length][width];
    }

    /**
     * Prints out a fail message if the program fails
     * @throws RuntimeException
     */
    public void fail(String errorMessage) throws RuntimeException {
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
            s = s.replace("\" "," ");
            s = s.replace("'|'" , " ");
            s = s.replace("\\{|\\" ," ");
            s = s.replace("'^'" ," ");
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

    /**
     * Resets barren land nodes to 0
     */
    public void clearBarren() {
        for(int i = 0; i < length; i++) {
            for(int j = 0; j < width; j++) {
                barrenRec[i][j] = 0;
            }
        }
    }

    /**
     * Sets all visited barren nodes to 1
     */
    public void setBarren() {
        ListIterator<Integer[]> iterator = allLand.listIterator();
        while(iterator.hasNext()) {
            Integer rectangle [] = iterator.next();
            for(int i = rectangle[0]; i < rectangle[2]; i++) {
                for(int j = rectangle[1]; j < rectangle[3]; j++) {
                    barrenRec[i][j] = 1;
                }
            }
        }
    }

    /**
     * Adds barren rectangle to queue to be visited
     * @param xIndex, coordinate
     * @param yIndex, coordinate
     */
    public void addToQueue(int xIndex, int yIndex) {
        if(barrenRec[xIndex][yIndex] == 0) {
            queue.add(new Integer[] {xIndex, yIndex});
        }
    }



}

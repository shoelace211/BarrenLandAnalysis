import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;

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
    private int visitedLand[][];

    /**
     * Constructor
     */
    public Land() {
        allLand = new LinkedList<Integer[]>();
        queue = new LinkedList<Integer[]>();
        sqMetersMap = new HashMap<Integer, Integer>();
        visitedLand = new int [length][width];
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
            s = s.replaceAll("\" ","");
            s = s.replaceAll("|" , "");
            s = s.replaceAll("\\{|\\}" ,"");
            s = s.replaceAll("^" ,"");
            if(!s.isEmpty()) {
                String points [] = s.split(" ");
                if(points.length < 4) {
                    fail("Not enough coordinates in set.");
                }
                if(Integer.valueOf(points[0]) >= 0 && Integer.valueOf(points[1]) >= 0 &&
                        Integer.valueOf(points[2]) >= 0 && Integer.valueOf(points[3]) >= 0 &&
                        Integer.valueOf(points[0]) < 400 && Integer.valueOf(points[1]) < 600 &&
                        Integer.valueOf(points[2]) < 400 && Integer.valueOf(points[3]) < 600) {
                    Integer temp [] = {Integer.valueOf(points[0]), Integer.valueOf(points[1]),
                            Integer.valueOf(points[2]), Integer.valueOf(points[3])};
                    allLand.add(temp);
                } else
                    fail("Coordinates out of bounds");
            }
        }
    }

    /**
     * Sets barren land nodes to 0
     */
    public void clearBarren() {
        for(int i = 0; i < length; i++) {
            for(int j = 0; j < width; j++) {
                visitedLand[i][j] = 0;
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
            for(int i = rectangle[0]; i <= rectangle[2]; i++) {
                for(int j = rectangle[1]; j <= rectangle[3]; j++) {
                    visitedLand[i][j] = 1;
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
        if(visitedLand[xIndex][yIndex] == 0) {
            queue.add(new Integer[] {xIndex, yIndex});
        }
    }

    /**
     * Calculates fertile land and places results in a HashMap
     * Traverses coordinate grid, all barren land has same identifier
     */
    public void calcFertileLand() {
        int land = 1;
        int x = 0;
        int y = 0;
        while(x < length && y < width) {
            if(queue.isEmpty()) { //fertile land since queue is empty
                Integer node [] = {x, y};
                if(visitedLand[x][y] == 0) { //if coordinates at [x][y] haven't been added, add to queue
                    land++;
                    sqMetersMap.put(land, 0);
                    queue.add(node);
                }
                if(x == (length - 1)) { //pass over all available land
                    x = 0;
                    y++;
                } else
                    x++;
            }
            if(!queue.isEmpty()) {
                Integer node [] = queue.pop();
                int i = node[0];
                int j = node[1];
                if(visitedLand[i][j] == 0) { //adds remaining fertile coordinates to queue
                    if(i > 0) {
                        addToQueue(i - 1, j);
                    }
                    if(i < (length - 1)) {
                        addToQueue(i + 1, j);
                    }
                    if(j > 0) {
                        addToQueue(i, j - 1);
                    }
                    if(j < (width - 1)) {
                        addToQueue(i, j + 1);
                    }
                    visitedLand[i][j] = land;
                    sqMetersMap.put(land, (sqMetersMap.get(land) + 1));
                }
            }
        }
    }

    /**
     * Prints fertile land results
     * @return the sorted fertile array results
     */
    public String printResults() {
        int result [] = new int[sqMetersMap.values().size()];
        int i = 0;
        for(Map.Entry<Integer, Integer> entry : sqMetersMap.entrySet()) {
            result[i] = entry.getValue();
            i++;
        }
        Arrays.sort(result);
        return(Arrays.toString(result)).replaceAll("\\[|\\]|,", " ");
    }
}

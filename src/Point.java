

/*This point class is meant to serve as a more convenient way to store a coordinate pair.
 * The class has two constructors:
 * - One for two integer coordinates
 * - One for entering coordinates as a string in the form (x, y)
 */
public class Point {
    public final int x,y;
    public final String cords;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.cords = String.format("(%s, %s)",x,y);
    }

    Point(String cords) {
        // Splits input string int two coordinates:
        String[] cordHalves = cords.substring(1,cords.length()-1).split(",");
        this.x = Integer.parseInt(cordHalves[0]);
        this.y = Integer.parseInt(cordHalves[1].trim());
        this.cords = cords;
    }
}

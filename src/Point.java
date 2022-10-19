public class Point {
    public final int x,y;
    public final String coords;

    Point(String cords) {
        String[] cordHalves = cords.substring(1,cords.length()-1).split(",");
        this.coords = cords;
        this.x = Integer.parseInt(cordHalves[0]);
        this.y = Integer.parseInt(cordHalves[1].trim());
    }
}

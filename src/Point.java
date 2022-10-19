public class Point {
    public final int x,y;
    public final String coords;

    Point(String coords) {
        String[] coordHalves = coords.substring(1,coords.length()-1).split(",");
        this.coords = coords;
        this.x = Integer.parseInt(coordHalves[0]);
        this.y = Integer.parseInt(coordHalves[1].trim());
    }
}

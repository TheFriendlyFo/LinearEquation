public class Point {
    public final double x,y;


    Point(String coords) {
        String[] coordHalves = coords.substring(1,coords.length()-1).split(",");
        this.x = Double.parseDouble(coordHalves[0]);
        this.y = Double.parseDouble(coordHalves[1].trim());
    }

    public String getPoint() {
        return String.format("(%s, %s)",x,y);
    }
}

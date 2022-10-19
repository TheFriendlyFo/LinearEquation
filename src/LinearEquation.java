import java.math.BigInteger;

public class LinearEquation {
    private final Point p1,p2;
    public final boolean isUndefined;

    LinearEquation(String p1, String p2) {
        this.p1 = new Point(p1);
        this.p2 = new Point(p2);
        isUndefined = this.p2.x - this.p1.x == 0;
    }

    private static double round(double roundNum, int decimals) {
        return Math.round(roundNum * Math.pow(10, decimals)) / Math.pow(10,decimals);
    }

    // Calculates and returns the distance between the two points rounded to the hundredths place:
    public double dist() {
        return round(Math.sqrt(Math.pow(p2.x-p1.x,2) + Math.pow(p2.y-p1.y, 2)), 2);
    }

    // Calculates and returns the slope as a double
    public double slope() {return (double) (p2.y - p1.y) / (p2.x-p1.x);}
    public String slopeStr() {
        int dy = p2.y - p1.y;
        int dx = p2.x - p1.x;
        if (dy == 0) {
            return "";
        } else if (dy == 1 && dx == 1) {
            return "x + ";
        } else {
            int gcd = new BigInteger(String.valueOf(p2.y-p1.y)).gcd(new BigInteger(String.valueOf(p2.x-p1.x))).intValue();
            return String.format("%s/%sx + ", dy/gcd, dx/gcd);
        }
    }

    public String equation() {
        return String.format("y = %s%s", slopeStr(), yIntercept());
    }

    public double yIntercept() {
        return round((p2.y-slope()*p2.x), 2);
    }

    public double angle() {
        return round(Math.toDegrees((Math.atan(slope()) + Math.toRadians(p2.x >= p1.x ? 360 : 180)) % (Math.PI*2)), 3);
    }

    public double calc(double x) {return slope() * x + yIntercept();}

    public String lineInfo() {
        return String.format("Equation of the line going through points %s and %s:\n", p1.coords, p2    .coords) +
                equation() +
                String.format("\n\nSlope: %s\n", slope()) +
                String.format("Distance between the two points: %s\n", dist()) +
                String.format("Y intercept: %s\n", yIntercept()) +
                String.format("Angle of the second point relative to the first: %s°\n", angle());
    }
}
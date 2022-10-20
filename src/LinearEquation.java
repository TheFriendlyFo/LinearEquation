import java.math.BigInteger;

public class LinearEquation {
    private final Point p1,p2;

    LinearEquation(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    // Useful method for rounding to given decimal places.
    private static double round(double roundNum, int decimals) {
        return Math.round(roundNum * Math.pow(10, decimals)) / Math.pow(10,decimals);
    }

    // Calculation methods:

    // Calculates and returns the distance between the two points with the standard formula rounded to the hundredths:
    public double dist() {
        return round(Math.sqrt(Math.pow(p2.x-p1.x,2) + Math.pow(p2.y-p1.y, 2)), 2);
    }
    // Calculates and returns the slope as a double:
    public double slope() {return (double) (p2.y - p1.y) / (p2.x-p1.x);}
    // Calculates, rounds, and returns y intercept:
    public double yIntercept() {
        return round((p2.y - slope() * p2.x), 2);
    }
    // Calculates the angle with my very own homebrew angle formula:  (:
    public double angle() {
        return round(Math.toDegrees((Math.atan(slope()) + Math.PI * p2.x >= p1.x ? 2 : 1) % (Math.PI*2)), 3);
    }
    // Calculates a y value for a given x input:
    public double calc(double x) {return slope() * x + yIntercept();}

    // Calculates and formats the slope as a fraction:
    public String slopeStr() {
        int dy = Math.abs(p2.y - p1.y);
        int dx = Math.abs(p2.x - p1.x);

        if (dy == 0) {
            // If the slope is 0, it returns nothing, as the x term will be 0:
            return "";
        } else if (dy == dx) {
            // If the slope is one, it simplifies the slope to just "x":
            return "x";
        } else {
            // Calculates the sign in front of the slope fraction:
            String sign = (p2.y<p1.y ^ p2.x<p1.x) ? "-" : "";
            // Uses some weird BigInteger voodoo to find the gcd and simplify the fraction:
            int gcd = new BigInteger(String.valueOf(p2.y-p1.y)).gcd(new BigInteger(String.valueOf(p2.x-p1.x))).intValue();
            dy /= gcd;
            dx /= gcd;
            // Does some extra formatting and returns the result:
            return String.format("%s%s%sx", sign, dy, dx == 1 ? "" : "/" + dx);
        }
    }

    public String equation() {
        String slopeStr = slopeStr();
        double yInt = yIntercept();

        if (yInt != 0.0 && !slopeStr.isEmpty()) {
            return String.format("y = %s + %s", slopeStr(), yIntercept());
        } else {
            return String.format("y = %s", slopeStr().isEmpty() ? yInt : slopeStr);
        }
    }
    public String lineInfo() {
        return String.format("The two points used to construct the equation are: %s, and %s\n", p1.cords, p2.cords) +
                String.format("Equation: %s\n", equation()) +
                String.format("Slope: %s\n", slope()) +
                String.format("Y intercept: %s\n", yIntercept()) +
                String.format("Distance between the two points: %s\n", dist()) +
                String.format("Angle of the second point relative to the first: %s\n", angle());
    }
}
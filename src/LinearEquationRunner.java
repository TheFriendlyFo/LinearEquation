import java.util.Scanner;

public class LinearEquationRunner {
    public static void main(String[] args) {

        // Sets up a scanner for input:
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome!");

        // Gets points for equation:
        System.out.print("Enter first coordinate: ");
        Point p1 = new Point(scan.nextLine());
        System.out.print("Enter second coordinate: ");
        Point p2 = new Point(scan.nextLine());

        // Tests for undefined entries:
        if (p2.x != p1.x) {
            // If the entries do not result in an undefined equation, it constructs a new LinearEquation object:
            LinearEquation equation = new LinearEquation(p1, p2);
            // Printing the equation's information:
            System.out.println(equation.lineInfo());

            // Gets the y value for a given x value:
            System.out.print("Enter a value for x: ");
            double testX = scan.nextDouble();
            System.out.printf("The point on the line is: (%s, %s)", testX, equation.coordinateForX(testX));

        } else {
            // If the entries result in an undefined line, it sends the user an error message:
            System.out.println("These points do not form a function and have an undefined slope.");
            System.out.printf("This equation can be represented by: x = %s", p1.x);
        }
    }
}

import java.util.Scanner;

public class LinearEquationRunner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter first coordinate: ");
        Point p1 = new Point(scan.nextLine());
        System.out.print("Enter second coordinate: ");
        Point p2 = new Point(scan.nextLine());

        if (p2.x != p1.x) {
            LinearEquation equation = new LinearEquation(p1, p2);
            System.out.println(equation.lineInfo());

            System.out.print("Enter a value for x: ");
            double testX = scan.nextDouble();
            System.out.printf("The point on the line is: (%s, %s)", testX, equation.calc(testX));

        } else {
            System.out.println("These points do not form a function and have an undefined slope.");
            System.out.printf("This equation can be represented by: x = %s", p1.x);
        }
    }
}

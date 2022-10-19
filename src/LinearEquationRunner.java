import java.util.Scanner;

public class LinearEquationRunner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter first coordinate: ");
        String p1 = scan.nextLine();
        System.out.print("Enter second coordinate: ");
        String p2 = scan.nextLine();

        LinearEquation equation = new LinearEquation(p1,p2);
        System.out.println(equation.lineInfo());

        System.out.print("Enter a value for x: ");
        double testX = scan.nextDouble();
        System.out.printf("The point on the line is: (%s, %s)", testX, equation.calc(testX));
    }
}

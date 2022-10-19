import java.util.Scanner;

public class LinearEquationRunner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String p1 = scan.nextLine();
        String p2 = scan.nextLine();

        LinearEquation equation = new LinearEquation(p1,p2);
        System.out.println(equation.lineInfo());
    }
}

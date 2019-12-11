import java.util.Scanner;

public class Homework0421 {
    public static void main(String[] args) {
        for (int i=0 ; i < 2 ; i++) {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter a SSN : ");
            String SSN = input.next();

            if (SSN.charAt(3) == '-' && SSN.charAt(6) == '-') {
                System.out.println(SSN + " is a valid social security number ");
            } else {
                System.out.println(SSN + " is an invalid social security number ");
            }
        }
    }
}

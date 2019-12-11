import java.util.Scanner;

public class Homework0206 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter three number for calculating: ");

        int num = input.nextInt();

        int a = num % 100;
        int b = a % 10;
        int c = num / 100;

        System.out.println("The sum is " + (a / 10 + b + c));
    }
}

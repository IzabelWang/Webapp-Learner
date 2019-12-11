import java.util.Scanner;

public class Homework0308 {
    public static void main(String[] args) {
        Scanner input1 = new Scanner(System.in);
        System.out.print("plz Enter the first number : ");
        int a = input1.nextInt();

        Scanner input2 = new Scanner(System.in);
        System.out.print("plz Enter the second number : ");
        int b = input2.nextInt();

        Scanner input3 = new Scanner(System.in);
        System.out.print("plz Enter the third number : ");
        int c = input3.nextInt();

        if (a <= b) {
            if (c <= a) {
                System.out.println(c + "," + a + "," + b);
            }
            else if (c >= b) {
                System.out.println(a + "," + b + "," + c);
            }
            else {
                System.out.println(a + "," + c + "," + b);
            }
        }
        else {
            if (c >= a) {
                System.out.println(b + "," + a + "," + c);
            }
            else if (c <= b) {
                System.out.println(c + "," + b + "," + a);
            }
            else {
                System.out.println(b + "," + c + "," + a);
            }
        }
    }
}

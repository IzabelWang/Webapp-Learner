public class Homework0510 {
    public static void main(String[] args) {
        int j = 0 ;
        for (int i= 100 ; i <= 1000 ; i++) {
            if (i % 5 == 0 && i % 6 == 0) {
                System.out.print(i + " ");
                j++;
                if (j % 10 == 0) {
                    System.out.print("\n");
                }
            }
        }
    }
}
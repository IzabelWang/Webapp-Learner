import java.util.Scanner;

public class Homework0805 {

    /** Main method */
    public static void main(String[] args) {
        System.out.println("plz Enter two 3×3 matrix!!! ");
        System.out.print("Enter matrix1: ");
        Scanner input = new Scanner(System.in);

        int n = 3;

        /** 创建 matrix1 的矩阵 */
        double matrix1[][] = new double[n][n];
        for(int i = 0 ; i < matrix1.length ; i++){
            for(int j = 0 ; j < matrix1[i].length ; j++){
                matrix1[i][j] = input.nextDouble();
            }
        }

        System.out.print("Enter matrix2:");

        /** 创建 matrix2 的矩阵 */
        double[][] matrix2 = new double[n][n];
        for(int i = 0 ; i < matrix2.length ; i++){
            for(int j = 0 ; j < matrix2[i].length ; j++){
                matrix2[i][j] = input.nextDouble();
            }
        }

        double[][] matrix3 = addMatrix(matrix1,matrix2);

        System.out.println("\nThe matrix1：");
        printMatrix(matrix1);

        System.out.println("\nThe matrix2：");
        printMatrix(matrix2);

        System.out.println("\nThe result of the added matrices:");
        printMatrix(matrix3);
    }

    /** 矩阵相加的方法 */
    public static double[][] addMatrix(double[][] a, double[][] b){
        double[][] c = new double[a.length][b[0].length];
        for(int i = 0 ; i < a.length ; i++){
            for (int j = 0 ; j < b[i].length ; j++){
                c[i][j] = a[i][j] + b[i][j];
            }
        }
        return c;
    }

    /** 打印 matrix 矩阵的方法 */
    public static void printMatrix(double[][] matrix){
        for(int i = 0 ; i < matrix.length ; i++){
            for (int j = 0 ; j < matrix[i].length ; j++){
                System.out.print(matrix[i][j] + "\t\t");
            }
            System.out.println();
        }

    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [][] matrix = {{1,2,3},
                {4,5,6}};

        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix[i].length ; j++) {
                System.out.println(matrix[i][j]);
            }
        }
    }
}









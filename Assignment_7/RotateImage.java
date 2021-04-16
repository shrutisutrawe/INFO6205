package INFO6205.Assignment_7;

import java.util.Arrays;

public class RotateImage {
    public static void rotate(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        int temp = 0, col = matrix[0].length;
        for (int i = 0; i < (col / 2 + col % 2); i++) {
            for (int j = 0; j < col / 2; j++) {
                temp = matrix[col - 1 - j][i];
                matrix[col - 1 - j][i] = matrix[col - 1 - i][col - 1 - j];
                matrix[col - 1 - i][col - 1 - j] = matrix[j][col - 1 - i];
                matrix[j][col - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
//        for(int i =0 ; i < matrix.length;i++){
//            System.out.println(Arrays.toString(matrix[i]));
//        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        rotate(matrix);
    }
}

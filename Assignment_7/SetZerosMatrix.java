package INFO6205.Assignment_7;

import java.util.Arrays;

public class SetZerosMatrix {
    public static void setZeros(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        boolean rowFlag = false, colFlag = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0 && i == 0) {
                    rowFlag = true;
                }
                if (matrix[i][j] == 0 && j == 0) {
                    colFlag = true;
                }
                if (matrix[i][j] == 0 && i != 0 && j != 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0 && i == 0 && j != 0) {
                    int k = i;
                    while (k < matrix.length) {
                        matrix[k++][j] = 0;
                    }
                } else if (matrix[i][j] == 0 && i != 0 && j == 0) {
                    int k = j;
                    while (k < matrix[i].length) {
                        matrix[i][k++] = 0;
                    }
                }
            }
        }
        if (rowFlag) {
            int k = 0;
            while (k < matrix[0].length) {
                matrix[0][k++] = 0;
            }
        }
        if (colFlag) {
            int k = 0;
            while (k < matrix.length) {
                matrix[k++][0] = 0;
            }
        }
//        for(int i =0; i < matrix.length; i++){
//            System.out.println(Arrays.toString(matrix[i]));
//        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1}, {1, 0, 1}, {1, 1, 1}
        };
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        setZeros(matrix);
    }
}

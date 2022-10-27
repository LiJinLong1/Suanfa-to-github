package 算法基础.class05;

public class Code05_PrintMatrixSpiralOrder {

    public static void spiralOrderPrint(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR <= dR && tC <= dC) {
            printEdge(matrix, tR, tC, dR, dC);
            tR++;
            tC++;
            dR--;
            dC--;
        }

    }

    public static void printEdge(int[][] matrix, int tR, int tC, int dR, int dC) {

        if (tR == dR) {
            for (int i = tC; i <= dC; i++) {
                System.out.println(matrix[tR][i]);
            }
        } else if (tC == dC) {
            for (int i = tR; i <= dR; i++) {
                System.out.println(matrix[i][tC]);
            }
        } else {
            int curC = tC;
            int curR = tR;
            while (curC != dC) {
                System.out.println(matrix[tR][curC++]);
            }
            while (curR != dR) {
                System.out.println(matrix[curR++][dC]);
            }
            while (curC != tC) {
                System.out.println(matrix[dR][curC--]);
            }
            while (curR != tR) {
                System.out.println(matrix[curR--][tC]);
            }

        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12},
                {13, 14, 15, 16}};
        spiralOrderPrint(matrix);

    }
}
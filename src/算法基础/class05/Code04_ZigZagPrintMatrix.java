package 算法基础.class05;

/**
 * @author LiJinLong
 * @version 1.0
 * @date 2021/12/3 14:22
 */
public class Code04_ZigZagPrintMatrix {
    //    zigzag打印矩阵
    public static void printMatrixZigZag(int[][] matrix) {
        int aRow = 0;
        int aCol = 0;
        int bRow = 0;
        int bCol = 0;
        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;
        boolean fromUp = true;

        while (aRow != endR + 1) {
            printLevel(matrix, aRow, aCol, bRow, bCol, fromUp);
            aRow = aCol == endC ? aRow + 1 : aRow;
            aCol = aCol == endC ? aCol : aCol + 1;
            bCol = bRow == endR ? bCol + 1 : bCol;
            bRow = bRow == endR ? bRow : bRow + 1;
            fromUp = !fromUp;
        }
    }

    public static void printLevel(int[][] matrix, int aRow, int aCol, int bRow, int bCol, boolean fromUp) {
        if (fromUp) {
            while (aRow != bRow + 1) {
                System.out.println(matrix[bRow--][bCol++]);
            }
        } else {
            while (aRow != bRow + 1) {
                System.out.println(matrix[aRow++][aCol--]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};
        printMatrixZigZag(matrix);

    }
}

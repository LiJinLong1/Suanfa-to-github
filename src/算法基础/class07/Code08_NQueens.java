package 算法基础.class07;

public class Code08_NQueens {
    public static int nQueens1(int n) {
        if (n < 1) {
            return 0;
        }
        int[] record = new int[n];
        return process1(record, 0, n);
    }

    public static int process1(int[] record, int i, int n) {
        if (i == n) {
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            if (isValid(record, i, j)) {
                record[i] = j;
                res += process1(record, i + 1, n);
            }
        }
        return res;
    }

    public static boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (j == record[k] || Math.abs(record[k] - j) == Math.abs(k - i)) {
                return false;
            }
        }
        return true;
    }

    public static int nQueens(int n) {
        if (n < 1 || n > 32) {
            return 0;
        }
        int limit = n == 32 ? -1 : (1 << n) - 1;
        return process2(limit, 0, 0, 0);
    }

    private static int process2(int limit, int colLim, int leftDiaLim, int rightDiaLim) {
        if (colLim == limit) {
            return 1;
        }
        int pos = limit & (~(colLim | leftDiaLim | rightDiaLim));
        int mostRightOne = 0;
        int res = 0;
        while (pos != 0) {
            mostRightOne = pos & (~pos + 1);
            res += process2(limit, colLim | mostRightOne, (leftDiaLim | mostRightOne) << 1, (rightDiaLim | mostRightOne) >> 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(nQueens1(8));
        System.out.println(nQueens1(8));
    }
}
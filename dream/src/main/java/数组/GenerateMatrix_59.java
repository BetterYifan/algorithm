package 数组;

/**
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix
 */
public class GenerateMatrix_59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        int up = 0, down = n - 1, left = 0, right = n - 1;

        // 填充的元素
        int count = 1;

        while (true) {

            // 填充上边界
            for (int i = left; i <= right; i++) {
                res[up][i] = count++;
            }
            if (++up > down) break;

            // 填充右边
            for (int i = up; i <= down; i++) {
                res[i][right] = count++;
            }
            if (--right < left) break;

            //填充下边
            for (int i = right; i >= left; i--) {
                res[down][i] = count++;
            }
            if (--down < up) break;

            //填充左边
            for (int i = down; i >= up; i--) {
                res[i][left] = count++;
            }
            if (++left > right) break;
        }

        return res;
    }
}

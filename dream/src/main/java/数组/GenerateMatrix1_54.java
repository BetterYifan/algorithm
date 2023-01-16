package 数组;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 */
public class GenerateMatrix1_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> resp = new ArrayList<>();

        // m: 有m行，n：一行有n个元素
        int m = matrix.length, n = matrix[0].length;

        int up = 0, down = m - 1, left = 0, right = n - 1;

        while (true) {
            // 上边界
            for (int i = left; i <= right; i++) {
                resp.add(matrix[up][i]);
            }
            up++;
            if (up > down) {
                break;
            }

            // 右边
            for (int i = up; i <= down; i++) {
                resp.add(matrix[i][right]);
            }
            right--;
            if (right < left) {
                break;
            }

            //下边
            for (int i = right; i >= left; i--) {
                resp.add(matrix[down][i]);
            }
            down--;
            if (down < up) {
                break;
            }

            //左边
            for (int i = down; i >= up; i--) {
                resp.add(matrix[i][left]);
            }
            left++;
            if (left > right) {
                break;
            }
        }

        return resp;
    }

    public static void main(String[] args) {
        GenerateMatrix1_54 generateMatrix154 = new GenerateMatrix1_54();
        System.out.println(generateMatrix154.spiralOrder(new int[][]{{2, 5, 8}, {4, 0, -1}}));
    }
}

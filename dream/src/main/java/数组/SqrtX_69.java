package 数组;

/**
 * leecode-69
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * <p>
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去
 */
public class SqrtX_69 {

    public int mySqrt(int x) {
        if (x == 1) {
            return 1;
        }

        int left = 0;
        int right = x;

        while (right - left > 1) {
            int middle = left + ((right - left) >> 1);
            // 用/号，别用x号防止int越界
            if (x / middle > middle) {
                left = middle;
            } else if (x / middle < middle) {
                right = middle;
            } else {
                return middle;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        SqrtX_69 tmp = new SqrtX_69();
        System.out.println(tmp.mySqrt(2147395599));
    }
}

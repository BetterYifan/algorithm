package 数组;

/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 */
public class OrderArraySquare_977 {
    // 双指针，一头一尾
    public int[] sortedSquares(int[] nums) {
        int head = 0;
        int tail = nums.length - 1;

        int[] result = new int[nums.length];

        int index = nums.length - 1;
        while (head <= tail) {
            if (nums[tail] * nums[tail] > nums[head] * nums[head]) {
                result[index--] = nums[tail] * nums[tail];
                tail--;
            } else {
                result[index--] = nums[head] * nums[head];
                head++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        OrderArraySquare_977 orderArraySquare_977 = new OrderArraySquare_977();
        System.out.print(orderArraySquare_977.sortedSquares(new int[]{-4, -3, 1}));
    }
}

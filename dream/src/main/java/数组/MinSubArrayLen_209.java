package 数组;

/**
 * 给定一个含有n个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 */
public class MinSubArrayLen_209 {
    // 滑动窗口
    // 定义一个前一个后指针
    public int minSubArrayLen(int target, int[] nums) {
        int minSize = Integer.MAX_VALUE;
        int windowsBegin = 0;
        int windowsSum = 0;
        int windowsLen;

        for (int windowsEnd = 0; windowsEnd < nums.length; windowsEnd++) {
            windowsSum += nums[windowsEnd];
            // 开始滑动
            while (windowsSum >= target) {
                windowsLen = windowsEnd - windowsBegin + 1;
                minSize = Math.min(minSize, windowsLen);
                windowsSum -= nums[windowsBegin];
                windowsBegin++;
            }
        }

        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }

    public static void main(String[] args) {
        MinSubArrayLen_209 minSubArrayLen_209 = new MinSubArrayLen_209();

        System.out.println(minSubArrayLen_209.minSubArrayLen(9, new int[]{1, 2, 3, 9}));
    }
}

package 哈希表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * <p>
 * 你返回所有和为 0 且不重复的三元组。
 */
public class ThreeSum_15 {
    // 1. 先对原始数组排序
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return null;
        }
        List<List<Integer>> resp = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                return resp;
            }
            // 如果当前元素和前一位一样，跳过
            if ((i > 0) && (nums[i] == nums[i - 1])) {
                continue;
            }
            // 左右指针的index
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                // 相等的话，直接添加
                if ((nums[i] + nums[left] + nums[right]) == 0) {
                    resp.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重
                    while ((left < right) && (nums[left] == nums[left + 1])) {
                        left++;
                    }
                    while ((left < right) && (nums[right] == nums[right - 1])) {
                        right--;
                    }
                    left++;
                    right--;
                } else if ((nums[i] + nums[left] + nums[right]) < 0) {
                    // 三数之和小于0，left左移
                    left++;
                } else {
                    right--;
                }
            }
        }

        return resp;
    }

    public static void main(String[] args) {
        ThreeSum_15 threeSum_15 = new ThreeSum_15();
        threeSum_15.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }
}

package 哈希表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> resp = new ArrayList<>();

        if (nums.length < 4) {
            return resp;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {

            // 当前元素和上一个一样，去重
            if ((i > 0) && (nums[i] == nums[i - 1])) {
                continue;
            }

            int sum = target - nums[i];
            // 从i+1的位置往后找出和为target-nums[i]
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (nums[j] > sum) {
                    return resp;
                }
                if ((j > i + 1) && (nums[j] == nums[j - 1])) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    if (nums[j] + nums[left] + nums[right] == sum) {
                        resp.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        // 去重
                        while ((left < right) && (nums[left] == nums[left + 1])) {
                            left++;
                        }
                        while ((left < right) && (nums[right] == nums[right - 1])) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (nums[j] + nums[left] + nums[right] < sum) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return resp;
    }

    public static void main(String[] args) {
        FourSum_18 fourSum_18 = new FourSum_18();
        fourSum_18.fourSum(new int[]{2, 2, 2, 2}, 8);
    }
}

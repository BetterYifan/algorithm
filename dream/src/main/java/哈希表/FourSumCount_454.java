package 哈希表;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
 * <p>
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 */
public class FourSumCount_454 {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> valueCount1 = new HashMap<>();
        Map<Integer, Integer> valueCount2 = new HashMap<>();


        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int key = nums1[i] + nums2[j];
                if (!valueCount1.containsKey(key)) {
                    valueCount1.put(key, 1);
                    continue;
                }

                valueCount1.put(key, valueCount1.get(key)+1);
            }
        }

        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                int key = nums3[i] + nums4[j];
                if (!valueCount2.containsKey(key)) {
                    valueCount2.put(key, 1);
                    continue;
                }
                valueCount2.put(key, valueCount2.get(key)+1);
            }
        }

        int res = 0;
        // 遍历
        for (Integer key : valueCount1.keySet()) {
            Integer count = valueCount1.get(key);
            if (valueCount2.containsKey(-key)) {
                res += (count * valueCount2.get(-key));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        FourSumCount_454 fourSumCount_454 = new FourSumCount_454();
        fourSumCount_454.fourSumCount(new int[]{-1, -1}, new int[]{-1, 1}, new int[]{-1, 1}, new int[]{1, -1});
    }
}

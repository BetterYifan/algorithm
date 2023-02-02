package 哈希表;

import java.util.*;

/**
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序。
 */
public class Intersection_349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int ele : nums1) {
            set1.add(ele);
        }

        for (int v : nums2) {
            if (set1.contains(v)) {
                set2.add(v);
            }
        }

        //set转int
        return set2.stream().mapToInt(x -> x).toArray();
    }
}

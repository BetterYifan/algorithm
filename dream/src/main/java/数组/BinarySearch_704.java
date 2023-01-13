package 数组;

/**
 * 二分查找
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * ！注意边界的定义
 */
public class BinarySearch_704 {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length;

        while (left < right) {
            // 注意>>优先级低于+号
            int middle = left + ((right - left) >> 1);
            if (nums[middle] < target) {
                // 此时在右区间，范围是[middle, right)
                left = middle + 1;
            } else if (nums[middle] > target) {
                // 此时在左区间，范围是[left, middle)
                right = middle;
            } else {
                return middle;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        BinarySearch_704 binarySearch704 = new BinarySearch_704();
        int res = binarySearch704.search(new int[]{0, 1, 2}, 2);
        System.out.println(res);
    }
}

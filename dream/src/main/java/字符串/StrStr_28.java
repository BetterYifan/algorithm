package 字符串;

/**
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
 */
public class StrStr_28 {
    public int strStr(String haystack, String needle) {
        int left = 0;
        int right = needle.length() - 1;

        while (right <= haystack.length() - 1) {
            if (haystack.substring(left, right + 1).equals(needle)) {
                return left;
            }
            left++;
            right++;
        }
        return -1;
    }

    /**
     * nnd kmp真难理解
     */

    // 生成前缀表(next数组)，减一， 每个元素代表遇到冲突后要回退到哪里
    // aabbaac -> [0,1,0,0,1,2,0]
//    private void preFix(int[] next, String str) {
//        // 指向前缀的末尾位置
//        int j = -1;
//        next[0] = j;
//
//        for (int i = 1; i < str.length(); i++) {
//            // 处理前后缀不同的情况, i代表后缀的末尾位置
//            while (j > 0 && str.charAt(i) != str.charAt(j + 1)) {
//
//            }
//            // 找到相同前后缀
//        }
//    }
}

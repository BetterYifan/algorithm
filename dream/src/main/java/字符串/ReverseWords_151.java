package 字符串;

import java.util.Arrays;
import java.util.Collections;

/**
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * <p>
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * <p>
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * <p>
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 */
public class ReverseWords_151 {
    // 不用split分割后再拼接，空间复杂度O(1).
    public String reverseWords(String s) {
        StringBuilder sb = removeSpace(s);
        reverseString(sb, 0, sb.length()-1);
        reverseEachWord(sb);
        return sb.toString();
    }

    // 移除空格
    private StringBuilder removeSpace(String s) {
        int start = 0;
        int end = s.length() - 1;

        // 去除首尾的空格
        while (s.charAt(start) == ' ') {
            start++;
        }
        while (s.charAt(end) == ' ') {
            end--;
        }

        StringBuilder sb = new StringBuilder();
        //拼接
        while (start <= end) {
            char c = s.charAt(start);
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            start++;
        }
        return sb;
    }

    //反转, end代表词的结束位置
    private void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char tmp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, tmp);
            start++;
            end--;
        }
    }

    private void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int n = sb.length();

        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') {
                end++;
            }
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }

    public static void main(String[] args) {
        ReverseWords_151 reverseWords_151 = new ReverseWords_151();
        String tm = reverseWords_151.reverseWords("  hello world  ");
        System.out.println(tm);
    }
}

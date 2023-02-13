package 字符串;

public class LeecodeReverseLeftWords_58 {
    // 不申请额外的空间
    public String reverseLeftWords(String s, int n) {
        if (n >= s.length() || n == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s);
        // 反转前n区间的
        reverseString(sb, 0, n - 1);
        reverseString(sb, n, sb.length() - 1);
        sb.reverse();
        return sb.toString();
    }

    private void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char tmp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, tmp);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        LeecodeReverseLeftWords_58 leecodeReverseLeftWords_58 = new LeecodeReverseLeftWords_58();
        leecodeReverseLeftWords_58.reverseLeftWords("abcdefg", 2);
    }
}

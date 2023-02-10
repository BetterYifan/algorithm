package 字符串;

public class ReverseString_344 {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        for (; left < right; ) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }
}

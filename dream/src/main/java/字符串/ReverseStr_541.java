package 字符串;

/**
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * <p>
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 */
public class ReverseStr_541 {
    // 注意题目说的是每计数到2K，就要反转
    public String reverseStr(String s, int k) {
        char[] sChar = s.toCharArray();

        for (int i = 0; i < s.length(); i += 2 * k) {
            // 剩余字符小于2k，但是大于k
            if (i + k <= sChar.length) {
                reverse(sChar, i, i + k - 1);
                continue;
            }
            reverse(sChar, i, sChar.length - 1);
        }
        return new String(sChar);
    }

    private void reverse(char[] ch, int i, int j) {
        for (; i < j; i++, j--) {
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
        }
    }

    public static void main(String[] args) {
        ReverseStr_541 reverseStr_541 = new ReverseStr_541();
        reverseStr_541.reverseStr("krmyfshbspcgtesxnnljhfursyissjnsocgdhgfxubewllxzqhpasguvlrxtkgatzfybprfmmfithphckksnvjkcvnsqgsgosfxc", 20);
    }
}

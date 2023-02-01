package 哈希表;

import java.util.HashMap;
import java.util.Objects;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 */
public class IsAnagram_242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Integer, Integer> hash1 = new HashMap<>(26);
        HashMap<Integer, Integer> hash2 = new HashMap<>(26);

        for (int i = 0; i < s.length(); i++) {
            Integer key = s.charAt(i) - 'a';
            if (!hash1.containsKey(key)) {
                hash1.put(key, 0);
            }
            Integer v = hash1.get(key);
            hash1.replace(key, ++v);
        }

        for (int i = 0; i < t.length(); i++) {
            Integer key = t.charAt(i) - 'a';
            if (!hash2.containsKey(key)) {
                hash2.put(key, 0);
            }
            Integer v = hash2.get(key);
            hash2.replace(key, ++v);
        }

        for (int i = 0; i < 26; i++) {
            if (!Objects.equals(hash1.get(i), hash2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsAnagram_242 isAnagram_242 = new IsAnagram_242();

        isAnagram_242.isAnagram("rat", "cat");
    }
}

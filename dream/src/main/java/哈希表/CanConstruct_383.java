package 哈希表;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * <p>
 * 如果可以，返回 true ；否则返回 false 。
 * <p>
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 */
public class CanConstruct_383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> ranMap = new HashMap<>();
        Map<Character, Integer> magMap = new HashMap<>();

        for (int i = 0; i < ransomNote.length(); i++) {
            Character key = ransomNote.charAt(i);
            if (!ranMap.containsKey(key)) {
                ranMap.put(key, 1);
                continue;
            }
            ranMap.put(key, ranMap.get(key) + 1);
        }

        for (int i = 0; i < magazine.length(); i++) {
            Character key = magazine.charAt(i);
            if (!magMap.containsKey(key)) {
                magMap.put(key, 1);
                continue;
            }
            magMap.put(key, magMap.get(key) + 1);
        }

        // magMap key的size要大于ran
        for (Character key : ranMap.keySet()) {
            Integer count = ranMap.get(key);
            if (!magMap.containsKey(key) || magMap.get(key) < count) {
                return false;
            }
        }
        return true;
    }
}

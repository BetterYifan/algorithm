package 哈希表;

import java.util.HashMap;
import java.util.Map;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * <p>
 * 「快乐数」定义为：
 * <p>
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为1，那么这个数就是快乐数。
 */
public class IsHappy_202 {
    public boolean isHappy(int n) {
        // 用于保留每次计算得到的sum
        Map<Integer, Boolean> res = new HashMap<>();

        // 新的结果不存在，并且新的结果不为1
        for (; n != 1 && !res.containsKey(n); ) {
            res.put(n, Boolean.TRUE);
            n = sum(n);
        }

        return n == 1;
    }

    // 求各个位数之和
    private int sum(int n) {
        int sum = 0;
        while (n >= 10) {
            int v = n % 10;
            sum += (v * v);
            n /= 10;
        }
        sum += (n * n);
        return sum;
    }
}

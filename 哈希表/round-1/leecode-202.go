package round_1

//编写一个算法来判断一个数 n 是不是快乐数。
//
//「快乐数」 定义为：
//
//对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
//然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
//如果这个过程 结果为 1，那么这个数就是快乐数。
//如果 n 是 快乐数 就返回 true ；不是，则返回 false 。

// 思路：题目说可能会循环，那就说明不为1；所以存储所有中间值，直到循环出现
func isHappy(n int) bool {
	suMap := make(map[int]bool)
	for n != 1 && !suMap[n] {
		suMap[n] = true
		n = sum(n)
	}
	return n == 1
}

func sum(n int) int {
	sum := 0
	for n > 0 {
		sum += (n % 10) * (n % 10)
		n = n / 10
	}
	return sum
}

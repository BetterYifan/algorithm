package 动态规划

func tribonacci(n int) int {
	if n <= 1 {
		return n
	}
	if n == 2 {
		return 1
	}
	first, second, third, sum := 0, 0, 1, 1

	for i := 3; i <= n; i++ {
		first = second
		second = third
		third = sum
		sum = first + second + third
	}
	return sum
}

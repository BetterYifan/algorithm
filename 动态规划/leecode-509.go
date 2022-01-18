package 动态规划

var dpTable = make(map[int]int)

// 状态转移方程：f(n)=f(n-1)+f(n-2)
func fib(n int) int {
	if n < 2 {
		return n
	}

	prev, curr, sum := 0, 0, 1

	for i := 2; i <= n; i++ {
		prev = curr
		curr = sum
		sum = prev + curr
	}
	return sum
}

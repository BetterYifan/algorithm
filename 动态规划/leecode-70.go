package 动态规划

// dp[0]=0,dp[1]=0
func minCostClimbingStairs(cost []int) int {
	n := len(cost)
	dp := make([]int, n)

	for i := 2; i <= n; i++ {
		dp[i] = min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2])
	}
	return dp[n-1]
}

func min(a, b int) int {
	if a < b {
		return a
	} else {
		return b
	}
}

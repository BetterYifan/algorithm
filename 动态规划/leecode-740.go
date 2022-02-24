package 动态规划

// 转换为打家劫舍问题，不能选择相邻等于删除
func deleteAndEarn(nums []int) int {
	maxVal := 0
	for _, n := range nums {
		if n > maxVal {
			maxVal = n
		}
	}
	sum := make([]int, maxVal+1)
	// val作为下标
	for _, val := range nums {
		sum[val] += val
	}
	return rob(sum)
}

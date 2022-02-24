package 动态规划

func rob2(nums []int) int {
	if len(nums) == 1 {
		return nums[1]
	}
	if len(nums) == 2 {
		return max(nums[0], nums[1])
	}

	// 将最后一个元素剔除
	tmp1 := nums[:len(nums)-1]
	dp1 := make([]int, len(tmp1))
	dp1[0] = tmp1[0]
	dp1[1] = max(tmp1[0], tmp1[1])
	for i := 2; i <= len(tmp1); i++ {
		dp1[i] = max(dp1[i-2]+tmp1[i], dp1[i-1])
	}

	// 将第一个元素剔除
	tmp2 := nums[1:]
	dp2 := make([]int, len(tmp2))
	dp2[0] = tmp2[0]
	dp2[1] = max(tmp2[0], tmp2[1])
	for i := 2; i <= len(tmp2); i++ {
		dp2[i] = max(dp2[i-2]+tmp2[i], dp2[i-1])
	}

	return max(dp1[len(nums)-2], dp2[len(nums)-2])
}

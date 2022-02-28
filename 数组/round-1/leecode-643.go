package round_1

//给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
//
//请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
//
//任何误差小于 10-5 的答案都将被视为正确答案。

func findMaxAverage(nums []int, k int) float64 {
	sum := 0
	// 先计算第一个滑动窗口
	for _, k := range nums[:k] {
		sum += k
	}
	max := func(a, b int) int {
		if a > b {
			return a
		}
		return b
	}
	res := sum
	// 开始滑动,从k坐标开始
	for i := k; i < len(nums); i++ {
		sum = sum + nums[i] - nums[i-k]
		res = max(res, sum)
	}
	return float64(res) / float64(k)
}

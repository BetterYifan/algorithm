package 动态规划

func maxProduct(nums []int) int {
	if len(nums) <= 0 {
		return 0
	}

	mid := nums[0]

	for i := 1; i < len(nums); i++ {
		if nums[i] == 0 {
			mid = 0
			continue
		}
		if mid != 0 {
			nums[i] *= mid
			mid = nums[i]
		} else {
			mid = nums[i]
		}
	}

	max := 0
	for i := 0; i < len(nums); i++ {
		if max < nums[i] {
			max = nums[i]
		}
	}
	return max
}

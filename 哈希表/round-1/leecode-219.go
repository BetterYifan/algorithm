package round_1

//给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。

func containsNearbyDuplicate(nums []int, k int) bool {
	tmp := make(map[int]int)
	for i := 0; i < len(nums); i++ {
		if index, exist := tmp[nums[i]]; !exist {
			tmp[nums[i]] = i
		} else {
			a := abs(index, i)
			if a <= k {
				return true
			}
		}
	}
	return false
}

func abs(a, b int) int {
	if a-b > 0 {
		return a - b
	} else {
		return b - a
	}
}

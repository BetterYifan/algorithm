package 动态规划

func canJump(nums []int) bool {
	if len(nums) == 0 {
		return false
	}
	maxLoc := 0

	for i := 0; i < len(nums); i++ {
		if i > maxLoc {
			return false
		}
		maxLoc = max(maxLoc, i+nums[i])
		if maxLoc >= len(nums) {
			return true
		}
	}
	return true
}

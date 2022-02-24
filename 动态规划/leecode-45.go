package 动态规划

func jump(nums []int) int {
	if len(nums) <= 1 {
		return 0
	}
	maxLoc := 0 // 目前能跳到的最远位置
	step := 0   //跳跃次数
	end := 0    // 上次跳跃可达范围右边界(下次起跳位置)

	for i := 0; i < len(nums)-1; i++ {
		maxLoc = max(maxLoc, i+nums[i])
		// 到达上次右边界后
		if i == end {
			end = maxLoc
			step++
		}
	}
	return step
}

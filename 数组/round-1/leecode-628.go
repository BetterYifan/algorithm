package round_1

import "sort"

//给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。

func maximumProduct(nums []int) int {
	sort.Ints(nums)
	length := len(nums)

	max := func(a, b int) int {
		if a > b {
			return a
		}
		return b
	}

	return max(nums[0]*nums[1]*nums[length-1], nums[length-1]*nums[length-2]*nums[length-3])
}

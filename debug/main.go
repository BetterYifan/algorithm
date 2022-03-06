package main

import (
	"fmt"
	"strings"
)

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
	fmt.Println(tmp1)
	for i := 2; i < len(tmp1); i++ {
		fmt.Println(dp1[i])
		dp1[i] = max(dp1[i-2]+tmp1[i], dp1[i-1])
	}

	// 将第一个元素剔除
	tmp2 := nums[1:]
	dp2 := make([]int, len(tmp2))
	dp2[0] = tmp2[0]
	dp2[1] = max(tmp2[0], tmp2[1])
	for i := 2; i < len(tmp2); i++ {
		dp2[i] = max(dp2[i-2]+tmp2[i], dp2[i-1])
	}

	return max(dp1[len(nums)-2], dp2[len(nums)-2])
}

func max(a, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}

func main() {
	wordPattern("abba", "dog cat cat fish")
}

func wordPattern(pattern string, s string) bool {
	strs := strings.Split(s, " ")

	if len(pattern) != len(strs) {
		return false
	}

	tmp := make(map[rune][]int) //map[char][index]
	for index, r := range pattern {
		if _, ok := tmp[r]; ok {
			tmp[r] = append(tmp[r], index)
		} else {
			tmp[r] = make([]int, 0)
			tmp[r] = append(tmp[r], index)
		}
	}

	for _, index := range tmp {
		// 根据index去char中比较
		ss := strs[index[0]]
		for _, i := range index {
			if ss != strs[i] {
				return false
			}
		}
	}
	return true
}

package main

import (
	"fmt"
	"math"
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
	res := shortestToChar("lovegleetcodew", 'e')
	fmt.Println(res)
}

func shortestToChar(s string, c byte) []int {
	cIndex := make([]int, 0)
	for i, v := range s {
		if byte(v) == c {
			cIndex = append(cIndex, i)
		}
	}
	res := make([]int, 0)
	min := func(a, b float64) int {
		if a < b {
			return int(a)
		} else {
			return int(b)
		}
	}
	//应该只要比较两个cIndex
	first, second := -1, 0
	for i := 0; i < len(s); i++ {
		if s[i] == c {
			first += 1
			second += 1
		}
		if first < 0 {
			res = append(res, int(math.Abs(float64(cIndex[second]-i))))
			continue
		}
		if second > len(cIndex)-1 {
			res = append(res, int(math.Abs(float64(cIndex[first]-i))))
			continue
		}
		res = append(res, min(math.Abs(float64(cIndex[first]-i)), math.Abs(float64(cIndex[second]-i))))

	}

	return res
}

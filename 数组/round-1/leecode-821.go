package round_1

import "math"

//给你一个字符串 s 和一个字符 c ，且 c 是 s 中出现过的字符。
//
//返回一个整数数组 answer ，其中 answer.length == s.length 且 answer[i] 是 s 中从下标 i 到离它 最近 的字符 c 的 距离 。
//
//两个下标 i 和 j 之间的 距离 为 abs(i - j) ，其中 abs 是绝对值函数。

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

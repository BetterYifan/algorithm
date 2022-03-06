package round_1

import "strings"

//给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
//
//这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。

//
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

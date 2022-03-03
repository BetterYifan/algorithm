package round_1

//给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。
//
//在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。

func longestPalindrome(s string) int {
	charMap := make(map[byte]int)
	for i := 0; i < len(s); i++ {
		charMap[s[i]]++
	}
	count := 0
	// 找出所有偶数对
	for _, cnt := range charMap {
		count += cnt / 2 * 2
	}
	// 小于则说明有奇
	if count < len(s) {
		return count + 1
	}
	return count
}

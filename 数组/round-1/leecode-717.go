package round_1

//有两种特殊字符：
//
//第一种字符可以用一比特 0 表示
//第二种字符可以用两比特（10 或 11）表示
//给你一个以 0 结尾的二进制数组 bits ，如果最后一个字符必须是一个一比特字符，则返回 true 。

func isOneBitCharacter(bits []int) bool {
	i := 0
	for i < len(bits) {
		i += bits[i] + 1
	}
	return i == len(bits)-1
}

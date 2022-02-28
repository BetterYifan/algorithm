package round_1

//给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。
//
//矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引

func transpose(matrix [][]int) [][]int {
	n, m := len(matrix), len(matrix[0])
	res := make([][]int, m)
	for i := range res {
		res[i] = make([]int, n)
	}
	for i, row := range matrix {
		for j, col := range row {
			res[j][i] = col
		}
	}
	return res
}

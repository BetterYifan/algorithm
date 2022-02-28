package round_1

//给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
//
//在「杨辉三角」中，每个数是它左上方和右上方的数的和。

func getRow(rowIndex int) []int {
	multi := make([][]int, rowIndex+1)
	for l := range multi {
		multi[l] = make([]int, l+1)
		multi[l][0], multi[l][l] = 1, 1
		for i := 1; i < l; i++ {
			multi[l][i] = multi[l-1][i-1] + multi[l-1][i]
		}
	}
	return multi[rowIndex]
}

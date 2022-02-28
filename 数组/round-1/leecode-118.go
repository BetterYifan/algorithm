package round_1

//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
//
//在「杨辉三角」中，每个数是它左上方和右上方的数的和。

func generate(numRows int) [][]int {
	res := make([][]int, 1)
	if numRows == 0 {
		return res
	}
	res[0] = []int{1}
	for row := 1; row < numRows; row++ {
		arr := make([]int, row+1)
		for k, _ := range arr {
			if k == 0 || k == row {
				arr[k] = 1
				continue
			}
			arr[k] = res[row-1][k-1] + res[row-1][k]
		}
		res = append(res, arr)
	}
	return res
}

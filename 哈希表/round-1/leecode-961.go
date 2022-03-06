package round_1

func repeatedNTimes(nums []int) int {
	tmp := make(map[int]struct{})
	for _, num := range nums {
		if _, ok := tmp[num]; !ok {
			tmp[num] = struct{}{}
		} else {
			return num
		}
	}
	return 0
}

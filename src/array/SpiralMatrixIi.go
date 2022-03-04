/**
 * 59. 螺旋矩阵 II
 *
 * @author xieyu
 * @keywords: 模拟
 * @ideas:
 * @since 2022-3-3 11:03:21
 */
func generateMatrix(n int) [][]int {
    res := make([][]int, n)
	for i := 0; i < len(res); i++ {
		res[i] = make([]int, n)
	}
	// 4个边界
	l, r, t, b := 0, n-1, 0, n-1
	cur := 1
	for cur <= n*n {
		for i := l; i <= r; i++ {
			res[t][i] = cur
			cur++
		}
		t++
		for i := t; i <= b; i++ {
			res[i][r] = cur
			cur++
		}
		r--
		for i := r; i >= l; i-- {
			res[b][i] = cur
			cur++
		}
		b--

		for i := b; i >= t; i-- {
			res[i][l] = cur
			cur++
		}
		l++
	}
	return res
}
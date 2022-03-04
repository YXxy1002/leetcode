/**
 * 54. 螺旋矩阵
 *
 * @author xieyu
 * @keywords: 模拟
 * @ideas:
 * @since 2022-3-3 11:03:21
 */
func spiralOrder(matrix [][]int) []int {
    ans := make([]int, len(matrix)*len(matrix[0]))
	t, r, l, b := 0, len(matrix[0])-1, 0, len(matrix)-1
	cur := 0
	for cur < len(ans) {
		for i := l; i <= r; i++ {
			ans[cur] = matrix[t][i]
			cur++
		}
		if cur>=len(ans) {
			break
		}
		t++
		for i := t; i <= b; i++ {
			ans[cur] = matrix[i][r]
			cur++
		}
		if cur>=len(ans) {
			break
		}
		r--
		for i := r; i >= l; i-- {
			ans[cur] = matrix[b][i]
			cur++
		}
		if cur>=len(ans) {
			break
		}
		b--
		for i := b; i >= t; i-- {
			ans[cur] = matrix[i][l]
			cur++
		}
		if cur>=len(ans) {
			break
		}
		l++
	}
	return ans
}
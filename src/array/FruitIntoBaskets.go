/**
 * 904. 水果成篮
 *
 * @author xieyu
 * @keywords: 滑动窗口
 * @ideas:
 * @since 2022-3-3 11:03:21
 */
func totalFruit(fruits []int) int {
    ans := 0
    // 窗口
	l := 0
	r := 0
	// 篮子
	m := make(map[int]int)
	for i := 0; i < len(fruits); i++ {
	    // 先直接加一种水果
		r++
		m[fruits[i]] = m[fruits[i]] + 1
		// 这时候如果篮子装了超过2个水果那就要循环丢弃水果直到篮子里只剩2种水果
		for {
			if len(m) < 3 {
				break
			}
			// 一直丢弃l指向的水果
			count := m[fruits[l]]
			count--
			if count <= 0 {
				delete(m, fruits[l])
			} else {
				m[fruits[l]] = count
			}
			l++
		}
		// 更新答案最大值
		sum := r - l
		if sum > ans {
			ans = sum
		}
	}
	return ans
}
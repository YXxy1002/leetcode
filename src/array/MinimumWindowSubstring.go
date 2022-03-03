/**
 * 76. 最小覆盖子串
 *
 * @author xieyu
 * @keywords: 滑动窗口
 * @ideas: 我们在 ss 上滑动窗口，通过移动 r 指针不断扩张窗口。当窗口包含 t 全部所需的字符后，如果能收缩，我们就收缩窗口直到得到最小窗口。
 * @since 2022-3-3 11:03:21
 */
func minWindow(s string, t string) string {
    // ori: s所有字符的map cnt:窗口
    ori, cnt := map[byte]int{}, map[byte]int{}
    for i := 0; i < len(t); i++ {
        ori[t[i]]++
    }

    sLen := len(s)
    len := math.MaxInt32// 最大数, 便于后面找到最小len
    ansL, ansR := -1, -1
    // 校验cnt是否包含t中不存在的字符
    check := func() bool {
        for k, v := range ori {
            if cnt[k] < v {
                return false
            }
        }
        return true
    }
    // 双指针
    for l, r := 0, 0; r < sLen; r++ {
        // 如果当前字符存在于ori中就加入cnt
        if r < sLen && ori[s[r]] > 0 {
            cnt[s[r]]++
        }
        // 如果通过了校验就开始缩小l
        for check() && l <= r {
            // 更新len的最小值和ansL ansR位置
            if (r - l + 1 < len) {
                len = r - l + 1
                ansL, ansR = l, l + len
            }
            // 去掉的如果是s中如果包含l指针的字符就同步把cnt中的该字符也去掉
            if _, ok := ori[s[l]]; ok {
                cnt[s[l]] --
            }
            l++
        }
    }
    // ansL没被赋值过,说明一次都没满足条件
    if ansL == -1 {
        return ""
    }
    return s[ansL:ansR]
}
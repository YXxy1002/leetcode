package linkedList.offer;

import linkedList.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 *
 * @author xieyu
 * @keywords: dfs
 * @ideas:
 * @since 2021-7-8 15:41:50
 */
public class CongWeiDaoTouDaYinLianBiaoIcof {
    List<Integer> list = new ArrayList<>();

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        print(head);
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    private void print(ListNode head) {
        if (head.next != null) {
            print(head.next);
        }
        list.add(head.val);
    }
}

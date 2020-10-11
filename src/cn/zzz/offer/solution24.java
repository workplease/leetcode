package cn.zzz.offer;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution24 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode first = head;
        ListNode second = head;
        ListNode last = dummyHead;
        int index = 0;
        //第一次遍历获得链表长度
        while (last.next != null){
            last = last.next;
            index++;
        }
        int[] array = new int[index];
        //第二次遍历将链表的值存到数组里面
        for (int i = 0;i < index;i ++){
            array[i] = first.val;
            first = first.next;
        }
        //第三次遍历将值进行调换
        for (int i = index - 1;i >= 0;i --){
            second.val = array[i];
            second = second.next;
        }
        return dummyHead.next;
    }
}

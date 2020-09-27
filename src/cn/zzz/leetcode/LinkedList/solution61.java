package cn.zzz.leetcode.LinkedList;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution61 {

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 链表中的点已经相连，一次旋转操作意味着：
     *
     * 先将链表闭合成环
     * 找到相应的位置断开这个环，确定新的链表头和链表尾
     *
     * 找到旧的尾部并将其与链表头相连 old_tail.next = head，整个链表闭合成环，同时计算出链表的长度 n。
     * 找到新的尾部，第 (n - k % n - 1) 个节点 ，新的链表头是第 (n - k % n) 个节点。
     * 断开环 new_tail.next = None，并返回新的链表头 new_head。
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        //首先判断特殊情况
        if (head == null) return null;
        if (head.next == null) return head;

        //将链表变成环
        ListNode old_tail = head;
        int n;
        for(n = 1; old_tail.next != null; n++)
            old_tail = old_tail.next;
        old_tail.next = head;

        //找到新尾节点: (n - k % n - 1)th node
        //找到新头节点: (n - k % n)th node
        ListNode new_tail = head;
        for (int i = 0; i < n - k % n - 1; i++)
            new_tail = new_tail.next;
        ListNode new_head = new_tail.next;

        //将环断裂
        new_tail.next = null;

        return new_head;
    }

    /**
     * 通过变量 length 得出链表的长度，方便后面转移
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight2(ListNode head,int k){
        if(head == null || head.next == null || k == 0) {
            return head;
        }
        int length = 1;
        ListNode tail = head;
        while(tail.next != null) {
            tail = tail.next;
            length++;
        }
        k = k % length;
        if(k==0) return head;
        //尾首相连
        tail.next = head;

        ListNode newhead = head;
        ListNode newtail = null;
        //找到链表需要断开的位置
        while (length-k>0) {
            newtail = newhead;
            newhead = newhead.next;
            k++;
        }
        newtail.next = null;
        return newhead;
    }
}

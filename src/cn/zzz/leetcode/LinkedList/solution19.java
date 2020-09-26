package cn.zzz.leetcode.LinkedList;

import java.util.LinkedList;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 */
public class solution19 {

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 首先我们将添加一个哑结点作为辅助，该结点位于列表头部。
     * 哑结点用来简化某些极端情况，例如列表中只含有一个结点，或需要删除列表的头部。
     * 在第一次遍历中，我们找出列表的长度 L。
     * 然后设置一个指向哑结点的指针，并移动它遍历列表，直至它到达第 (L - n) 个结点那里。
     * 我们把第 (L - n) 个结点的 next 指针重新链接至第 (L - n + 2) 个结点，完成这个算法。
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        int length = 0;
        ListNode list = head;
        while (list != null){
            list = list.next;
            length++;
        }
        length -= n;
        list = dummyHead;
        while (length > 0){
            length--;
            list = list.next;
        }
        ListNode delete = list.next;
        list.next = delete.next;
        delete.next = null;
        return dummyHead.next;
    }

    /**
     * 使用两个指针而不是一个指针。第一个指针从列表的开头向前移动 n+1 步，
     * 而第二个指针将从列表的开头出发。现在，这两个指针被 n 个结点分开。
     * 我们通过同时移动两个指针向前来保持这个恒定的间隔，直到第一个指针到达最后一个结点。
     * 此时第二个指针将指向从最后一个结点数起的第 n 个结点。
     * 我们重新链接第二个指针所引用的结点的 next 指针指向该结点的下下个结点。
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode first = dummyHead;
        ListNode second = dummyHead;
        //先移动第一个指针，使得两个指针相隔n+1
        while (n >= 0){
            n--;
            first = first.next;
        }
        //两个指针一起移动，直到第一个指针指向尾端，此时第二个指针就是指向需要删除的节点的上一个节点
        while (first != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummyHead.next;
    }
}

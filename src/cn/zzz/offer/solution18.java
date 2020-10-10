package cn.zzz.offer;

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution18 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 遍历删除指针，采用虚拟头指针：在单链表中移除头结点和移除其他节点的操作方式是不一样，需要单独写一段逻辑来处理移除头结点的情况。
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode(ListNode head, int val) {
        //指针为空的情况下返回null
        if (head == null) return null;
        //删除的是头节点，直接返回头节点的下一个节点
        if (head.val == val) return head.next;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode first = dummyHead;
        while (first.next != null){
            if (first.next.val == val){
                ListNode deleteNode = first.next;
                first.next = deleteNode.next;
                deleteNode.next = null;
                break;
            }
            first = first.next;
        }
        return dummyHead.next;
    }
}

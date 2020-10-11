package cn.zzz.offer;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution25 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 初始化： 伪头节点 dum ，节点 cur 指向 dum 。
     * 循环合并： 当 l1或 l2为空时跳出；
         * 当 l1.val<l2.val 时： cur 的后继节点指定为 l1，并 l1向前走一步；
         * 当 l1.val≥l2.val 时： cur 的后继节点指定为 l2，并l2向前走一步 ；
         * 节点 cur 向前走一步，即 cur = cur.next。
     * 合并剩余尾部： 跳出时有两种情况，即 l1为空 或 l2为空。
         * 若 l1=null ： 将 l1添加至节点 cur 之后；
         * 否则： 将 l2添加至节点 cur 之后。
     * 返回值： 合并链表在伪头节点 dumdum 之后，因此返回 dum.nextdum.next 即可。
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0), cur = dummyHead;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }
            else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return dummyHead.next;
    }
}

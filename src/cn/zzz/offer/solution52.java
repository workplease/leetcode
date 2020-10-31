package cn.zzz.offer;

import java.util.HashSet;

/**
 * 输入两个链表，找出它们的第一个公共节点。
 *
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。
 *
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
 * 在 A 中，相交节点前有 2 个节点；
 * 在 B 中，相交节点前有 3 个节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution52 {

    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) {
           val = x;
           next = null;
      }
   }

    /**
     * 首先遍历两个链表得到它们的长度，
     * 就能知道哪个链表比较长以及长的链表比短的链表多几个节点
     *
     * 第二次遍历的时候，在较长的链表上先走若干步
     * 接着同时在两个链表上遍历
     * 找到的第一个相同的节点就是它们的第一个公共节点
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //获得链表的长度
        int nLength1 = GetListLength(headA);
        int nLength2 = GetListLength(headB);

        ListNode pListHeadLong = headA;
        ListNode pListHeadShort = headB;
        int nLengthDif = nLength1 - nLength2;

        if (nLength2 > nLength1){
            pListHeadLong = headB;
            pListHeadShort = headA;
            nLengthDif = nLength2 - nLength1;
        }

        //将长的链表移动到和短的链表长度一致
        for (int i = 0;i < nLengthDif;++i)
            pListHeadLong = pListHeadLong.next;

        //两者同时移动
        while ((pListHeadLong != null) && (pListHeadShort != null) && (pListHeadLong != pListHeadShort)){
            pListHeadLong = pListHeadLong.next;
            pListHeadShort = pListHeadShort.next;
        }

        return pListHeadLong;
    }

    private int GetListLength(ListNode head) {
        int length = 0;
        ListNode pNode = head;
        while (pNode != null){
            length++;
            pNode = pNode.next;
        }
        return length;
    }
}

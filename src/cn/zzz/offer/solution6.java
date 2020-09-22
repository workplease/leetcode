package cn.zzz.offer;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution6 {

    private class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }

    /**
     * 创建一个栈，用于存储链表的节点
     * 创建一个指针，初始时指向链表的头节点
     * 当指针指向的元素非空时，重复下列操作：
     * 将指针指向的节点压入栈内
     * 将指针移到当前节点的下一个节点
     * 获得栈的大小 size，创建一个数组 arr，其大小为 size
     * 创建下标并初始化 index = 0
     * 重复 size 次下列操作：
     * 从栈内弹出一个节点，将该节点的值存到 arr[index]
     * 将 index 的值加 1
     * 返回 arr
     *
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null){
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] arr = new int[size];
        for (int i = 0;i < size;i++){
            arr[i] = stack.pop().val;
        }
        return arr;
    }

    /**
     * 思路二：（速度更快）
     * 对上面进行优化：
     * 不使用栈的结构进行存储，而是倒着遍历
     * 于是需要先遍历第一遍，获得长度，才能构建数组
     * @param head
     * @return
     */
    public int[] reversePrint2(ListNode head) {
        ListNode temp = head;
        int size = 0;
        while (head != null){
            size++;
            head = head.next;
        }
        int[] arr = new int[size];
        while (temp != null){
            arr[--size] = temp.val;
            temp = temp.next;
        }
        return arr;
    }
}

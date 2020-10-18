package cn.zzz.offer;

import cn.zzz.leetcode.LinkedList.solution138;

import java.util.HashMap;

/**
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 *
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution35 {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val,Node next,Node random) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    HashMap<Node, Node> visitedHash = new HashMap<Node, Node>();

    /**
     * 从头指针开始遍历整个图。
     *
     * 我们将链表看做一张图,Head是图的出发节点。
     * 当我们遍历到某个点时，如果我们已经有了当前节点的一个拷贝，我们不需要重复进行拷贝。
     * 如果我们还没拷贝过当前节点，我们创造一个新的节点，并把该节点放到已访问字典中，
     * 我们针对两种情况进行回溯调用：一个顺着 random 指针调用，另一个沿着 next 指针调用。
     * 然后我们分别对两个指针进行函数递归调用。
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (this.visitedHash.containsKey(head)) {
            return this.visitedHash.get(head);
        }

        Node node = new Node(head.val, null, null);
        this.visitedHash.put(head, node);

        node.next = this.copyRandomList(head.next);
        node.random = this.copyRandomList(head.random);

        return node;
    }
}

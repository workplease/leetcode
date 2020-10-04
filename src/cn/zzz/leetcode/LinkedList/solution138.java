package cn.zzz.leetcode.LinkedList;

import java.util.HashMap;

/**
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 *
 * 要求返回这个链表的 深拷贝。 
 *
 * 我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 *
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution138 {

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

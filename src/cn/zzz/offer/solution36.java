package cn.zzz.offer;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 *
 * 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。
 * 对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
 *
 * 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution36 {

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    Node head, pre;

    /**
     * 算法流程：
     *
     * treeToDoublyList(root)：
     *
     * 特例处理： 若节点 root为空，则直接返回；
     * 初始化： 空节点 pre ；
     * 转化为双向链表： 调用 dfs(root) ；
     * 构建循环链表： 中序遍历完成后，head 指向头节点， pre 指向尾节点，因此修改 head 和 pre 的双向节点引用即可。
     * 返回值： 返回链表的头节点 head 即可。
     *
     * @param root
     * @return
     */
    public Node treeToDoublyList(Node root) {
        if(root==null) return null;
        dfs(root);

        pre.right = head;
        head.left =pre;//进行头节点和尾节点的相互指向，这两句的顺序也是可以颠倒的

        return head;

    }

    /**
     * 算法流程：
     *
     * dfs(cur): 递归法中序遍历；
     *
     * 终止条件： 当节点 cur 为空，代表越过叶节点，直接返回；
     * 递归左子树，即 dfs(cur.left) ；
     * 构建链表：
     * 当 pre 为空时： 代表正在访问链表头节点，记为 head 。
     * 当 pre 不为空时： 修改双向节点引用，即 pre.right = cur ， cur.left = pre；
     * 保存 cur ： 更新 pre = cur ，即节点 cur 是后继节点的 pre ；
     * 递归右子树，即 dfs(cur.left) ；
     *
     * @param cur
     */
    public void dfs(Node cur){
        if(cur==null) return;
        dfs(cur.left);

        //pre用于记录双向链表中位于cur左侧的节点，即上一次迭代中的cur,当pre==null时，cur左侧没有节点,即此时cur为双向链表中的头节点
        if(pre==null) head = cur;
            //反之，pre!=null时，cur左侧存在节点pre，需要进行pre.right=cur的操作。
        else pre.right = cur;

        cur.left = pre;//pre是否为null对这句没有影响,且这句放在上面两句if else之前也是可以的。

        pre = cur;//pre指向当前的cur
        dfs(cur.right);//全部迭代完成后，pre指向双向链表中的尾节点
    }
}

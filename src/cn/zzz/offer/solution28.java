package cn.zzz.offer;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution28 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root,root);
    }

    /**
     * 输入位置对称的两个节点，判断值是否对称，默认为满二叉树的形状，不足的插入null
     * @param node1
     * @param node2
     * @return
     */
    private boolean isSymmetric(TreeNode node1, TreeNode node2){
        //节点都为空，返回true
        if (node1 == null && node2 == null)
            return true;
        //一方为空，返回false
        if (node1 == null || node2 == null)
            return false;
        //节点的值不一样，返回false
        if (node1.val != node2.val)
            return false;

        //目前对称的两个节点左右各自对称，形成递归
        return isSymmetric(node1.left,node2.right) && isSymmetric(node1.right,node2.left);
    }
}

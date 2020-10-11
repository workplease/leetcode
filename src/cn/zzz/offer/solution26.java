package cn.zzz.offer;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution26 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        boolean flag = false;
        if (A != null && B != null){
            //当A的根节点与B的根节点的值相同时，函数输入A,B的根节点
            if (A.val == B.val){
                flag = DoesTree1HaveTree2(A,B);
            }
            //当A还未找到时，从A的左子树进行寻找
            if (!flag) {
                flag = isSubStructure(A.left, B);
            }
            //当A还未找到时，从A的右子树进行寻找
            if (!flag){
                flag = isSubStructure(A.right,B);
            }
        }
        return flag;
    }

    private boolean DoesTree1HaveTree2(TreeNode A,TreeNode B){
        if (B == null){
            return true;
        }
        if (A == null){
            return false;
        }
        if (A.val != B.val){
            return false;
        }
        //A与B的值一致，传入A的子树和B的子树
        return DoesTree1HaveTree2(A.left,B.left) && DoesTree1HaveTree2(A.right,B.right);
    }
}

package cn.zzz.offer;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution27 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode mirrorTree(TreeNode root) {
        //传入的树为null时，输出null
        if (root == null){
            return null;
        }
        //左子树为null和右子树为null的时候将树返回
        if (root.left == null && root.right == null){
            return root;
        }
        //对称交换
        TreeNode Ttemp = root.left;
        root.left = root.right;
        root.right = Ttemp;
        //如果左子数，镜像翻转左子树
        if (root.left != null)
            mirrorTree(root.left);
        //如果右子数，镜像翻转右子树
        if (root.right != null)
            mirrorTree(root.right);
        return root;
    }
}

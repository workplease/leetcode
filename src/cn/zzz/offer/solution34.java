package cn.zzz.offer;

import java.util.*;

/**
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution34 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    /**
     * pathSum(root, sum) 函数：
     *
     * 初始化： 结果列表 res ，路径列表 path 。
     * 返回值： 返回 res 即可。
     *
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum);
        return res;
    }

    /**
     * recur(root, tar) 函数：
     *
     * 递推参数： 当前节点 root ，当前目标值 tar 。
     * 终止条件： 若节点 root 为空，则直接返回。
     * 递推工作：
     * 路径更新： 将当前节点值 root.val 加入路径 path ；
     * 目标值更新： tar = tar - root.val（即目标值 tar 从 sum 减至 0 ）；
     * 路径记录： 当 root 为叶节点 且路径和等于目标值 ，则将此路径 path 加入 res 。
     * 先序遍历： 递归左 / 右子节点。
     * 路径恢复： 向上回溯前，需要将当前节点从路径 path 中删除，即执行 path.pop() 。
     *
     * @param root
     * @param tar
     */
    void recur(TreeNode root, int tar) {
        if(root == null) return;
        path.add(root.val);
        tar -= root.val;
        //找到一条合格路径
        if(tar == 0 && root.left == null && root.right == null)
            res.add(new LinkedList(path));
        recur(root.left, tar);
        recur(root.right, tar);
        path.removeLast();
    }
}

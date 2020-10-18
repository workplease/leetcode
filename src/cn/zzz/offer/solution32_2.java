package cn.zzz.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution32_2 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 跳出循环的条件：队列为空
     *
     * 循环中的考虑：
     * 每次队列弹出几次，定义一个变量pollNum来进行控制弹出次数，而nextLevel用于增加左右子树的情况，需要在循环外定义list，当弹出结束后list置零
     *
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        //当根节点为null时，输出一个空的list
        if (root == null) return new LinkedList<>();
        //使用队列来存储数据
        Queue<TreeNode> queue = new LinkedList<TreeNode>(){{ add(root); }};
        //两个数值用于控制弹出队列的次数
        int nextLevel = 0;
        int pollNum = 1;
        List<List<Integer>> lists = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty() && pollNum > 0) {
            TreeNode node = queue.poll();
            ans.add(node.val);
            if(node.left != null) {
                queue.add(node.left);
                nextLevel++;
            }
            if(node.right != null) {
                queue.add(node.right);
                nextLevel++;
            }
            --pollNum;
            if (pollNum == 0){
                lists.add(ans);
                pollNum = nextLevel;
                nextLevel = 0;
                ans = new ArrayList<>();
            }
        }
        return lists;
    }
}

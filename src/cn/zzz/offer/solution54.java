package cn.zzz.offer;

/**
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution54 {

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }

    int res, k;

    /**
     * 终止条件： 当节点 root 为空（越过叶节点），则直接返回；
     *
     * 递归右子树： 即 dfs(root.right) ；
     *
     * 三项工作：
     * 提前返回： 若 k = 0 ，代表已找到目标节点，无需继续遍历，因此直接返回；
     * 统计序号： 执行 k = k - 1 （即从 k 减至 0 ）；
     * 记录结果： 若 k = 0 ，代表当前节点为第 k 大的节点，因此记录 res = root.val ；
     *
     * 递归左子树： 即 dfs(root.left)；
     *
     * @param root
     * @param k
     * @return
     */
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    void dfs(TreeNode root) {
        if(root == null) return;
        dfs(root.right);
        if(k == 0) return;
        if(--k == 0) res = root.val;
        dfs(root.left);
    }
}

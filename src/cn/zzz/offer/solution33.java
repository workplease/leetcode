package cn.zzz.offer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 *
 * 参考以下这颗二叉搜索树：
 *
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 *
 * 输入: [1,6,3,2,5]
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution33 {

    /**
     * 终止条件： 当 i≥j ，说明此子树节点数量 ≤1 ，无需判别正确性，因此直接返回 true ；
     *
     * 递推工作：
     * 划分左右子树： 遍历后序遍历的 [i,j] 区间元素，寻找第一个大于根节点的节点，索引记为 m 。此时，可划分出左子树区间 [i,m−1] 、右子树区间 [m,j−1] 、根节点索引 j 。
     *
     * 判断是否为二叉搜索树：
     *
     * 左子树区间 [i,m−1] 内的所有节点都应 < postorder[j] 。而第 1.划分左右子树 步骤已经保证左子树区间的正确性，因此只需要判断右子树区间即可。
     * 右子树区间 [m,j−1] 内的所有节点都应 > postorder[j] 。实现方式为遍历，当遇到 ≤postorder[j] 的节点则跳出；则可通过 p=j 判断是否为二叉搜索树。
     *
     * 返回值： 所有子树都需正确才可判定正确，因此使用与逻辑符 && 连接。
     *
     * p=j ： 判断此树是否正确。
     * recur(i,m−1) ： 判断此树的左子树是否正确。
     * recur(m,j−1) ： 判断此树的右子树是否正确。
     *
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    boolean recur(int[] postorder, int i, int j) {
        if(i >= j) return true;
        int p = i;
        while(postorder[p] < postorder[j]) p++;
        int m = p;
        while(postorder[p] > postorder[j]) p++;
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }
}

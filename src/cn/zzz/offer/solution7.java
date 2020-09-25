package cn.zzz.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 *
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *    链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 *    来源：力扣（LeetCode）
 *    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class solution7 {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 二叉树的前序遍历顺序是：根节点、左子树、右子树，每个子树的遍历顺序同样满足前序遍历顺序。
     *
     * 二叉树的中序遍历顺序是：左子树、根节点、右子树，每个子树的遍历顺序同样满足中序遍历顺序。
     *
     * 前序遍历的第一个节点是根节点，只要找到根节点在中序遍历中的位置，
     * 在根节点之前被访问的节点都位于左子树，在根节点之后被访问的节点都位于右子树，
     * 由此可知左子树和右子树分别有多少个节点。
     *
     * 由于树中的节点数量与遍历方式无关，通过中序遍历得知左子树和右子树的节点数量之后，
     * 可以根据节点数量得到前序遍历中的左子树和右子树的分界，
     * 因此可以进一步得到左子树和右子树各自的前序遍历和中序遍历，
     * 可以通过递归的方式，重建左子树和右子树，然后重建整个二叉树。
     *
     * 使用一个 Map 存储中序遍历的每个元素及其对应的下标，目的是为了快速获得一个元素在中序遍历中的位置。
     * 调用递归方法，对于前序遍历和中序遍历，下标范围都是从 0 到 n-1，其中 n 是二叉树节点个数。
     *
     * 递归方法的基准情形有两个：判断前序遍历的下标范围的开始和结束，
     * 若开始大于结束，则当前的二叉树中没有节点，返回空值 null。
     * 若开始等于结束，则当前的二叉树中恰好有一个节点，根据节点值创建该节点作为根节点并返回。
     *
     * 若开始小于结束，则当前的二叉树中有多个节点。
     * 在中序遍历中得到根节点的位置，从而得到左子树和右子树各自的下标范围和节点数量，
     * 知道节点数量后，在前序遍历中即可得到左子树和右子树各自的下标范围，
     * 然后递归重建左子树和右子树，并将左右子树的根节点分别作为当前根节点的左右子节点。
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0){
            return null;
        }
        Map<Integer,Integer> map = new HashMap<>();
        int length = preorder.length;
        for (int i = 0;i < length;i++){
            map.put(inorder[i],i);
        }
        TreeNode root = buildTree(preorder,0,length - 1,inorder,0,length - 1,map);
        return root;
    }

    private TreeNode buildTree(int[] preorder,int preStart,int preEnd,int[] inorder,int inStart,int inEnd,Map<Integer,Integer> map){
        if (preStart > preEnd){
            return null;
        }
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        if (preStart == preEnd) {
            return root;
        } else {
            int rootIndex = map.get(rootVal);
            int leftNodes = rootIndex - inStart, rightNodes = inEnd - rootIndex;
            TreeNode leftSubtree = buildTree(preorder, preStart + 1, preStart + leftNodes, inorder, inStart, rootIndex - 1, map);
            TreeNode rightSubtree = buildTree(preorder, preEnd - rightNodes + 1, preEnd, inorder, rootIndex + 1, inEnd, map);
            root.left = leftSubtree;
            root.right = rightSubtree;
            return root;
        }
    }
}

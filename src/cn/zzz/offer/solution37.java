package cn.zzz.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 *
 * 你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution37 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 序列化 Serialize ：
     *
     * 借助队列，对二叉树做层序遍历，并将越过叶节点的 null 也打印出来。
     *
     * 算法流程：
     * 特例处理： 若 root 为空，则直接返回空列表 "[]" ；
     * 初始化： 队列 queue （包含根节点 root ）；序列化列表 res ；
     * 层序遍历： 当 queue 为空时跳出；
     * 节点出队，记为 node ；
     * 若 node 不为空：① 打印字符串 node.val ，② 将左、右子节点加入 queue ；
     * 否则（若 node 为空）：打印字符串 "null" ；
     * 返回值： 拼接列表，用 ',' 隔开，首尾添加中括号；
     *
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        if(root == null) return "[]";
        StringBuilder res = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{ add(root); }};
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node != null) {
                res.append(node.val).append(",");
                queue.add(node.left);
                queue.add(node.right);
            }
            else res.append("null,");
        }
        res.deleteCharAt(res.length() - 1);
        res.append("]");
        return res.toString();
    }

    /**
     * 反序列化 Deserialize ：
     *
     * 基于本文开始推出的 node , node.left , node.right 在序列化列表中的位置关系，可实现反序列化。
     *
     * 利用队列按层构建二叉树，借助一个指针 i 指向节点 node 的左、右子节点，每构建一个 node 的左、右子节点，指针 i 就向右移动 1 位。
     *
     * 算法流程：
     * 特例处理： 若 data 为空，直接返回 null ；
     * 初始化： 序列化列表 vals （先去掉首尾中括号，再用逗号隔开），指针 i = 1 ，根节点 root （值为 vals[0] ），队列 queue（包含 root ）；
     * 按层构建： 当 queue 为空时跳出；
     * 节点出队，记为 node ；
     * 构建 node 的左子节点：node.left 的值为 vals[i] ，并将 node.left 入队；
     * 执行 i += 1 ；
     * 构建 node 的右子节点：node.left 的值为 vals[i] ，并将 node.left 入队；
     * 执行 i += 1 ；
     * 返回值： 返回根节点 root 即可；
     *
     * @param data
     * @return
     */
    public TreeNode deserialize(String data) {
        if(data.equals("[]")) return null;
        String[] vals = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{ add(root); }};
        int i = 1;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(!vals[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.left);
            }
            i++;
            if(!vals[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }
}

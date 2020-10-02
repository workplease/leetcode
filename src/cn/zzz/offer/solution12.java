package cn.zzz.offer;

import java.util.Stack;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，
 * 每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 *
 * 例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 *
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 *
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution12 {

    /**
     * 递归参数： 当前元素在矩阵 board 中的行列索引 i 和 j ，当前目标字符在 word 中的索引 k 。
     *
     * 终止条件：
     * 返回 falsefalse ：  行或列索引越界 或  当前矩阵元素与目标字符不同 或  当前矩阵元素已访问过 。
     * 返回 truetrue ： 字符串 word 已全部匹配，即 k = len(word) - 1 。
     *
     * 递推工作：
         * 标记当前矩阵元素： 将 board[i][j] 值暂存于变量 tmp ，并修改为字符 '/' ，代表此元素已访问过，防止之后搜索时重复访问。
         * 搜索下一单元格： 朝当前元素的 上、下、左、右 四个方向开启下层递归，使用 或 连接 （代表只需一条可行路径） ，并记录结果至 res 。
         * 还原当前矩阵元素： 将 tmp 暂存值还原至 board[i][j] 元素。
         * 回溯返回值： 返回 res ，代表是否搜索到目标字符串。
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                //从第一个元素开始进行索引，索引0
                if(dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }
    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
        if(k == word.length - 1) return true;
        char tmp = board[i][j];
        board[i][j] = '/';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
        //递归搜索匹配字符串过程中，需要 board[i][j] = '/' 来防止 “走回头路”。
        //当匹配字符串不成功时，会回溯返回，此时需要board[i][j] = tmp 来”取消对此单元格的标记”。
        //在DFS过程中，每个单元格会多次被访问的， board[i][j] = '/'只是要保证在当前匹配方案中不要走回头路。
        board[i][j] = tmp;
        return res;
    }
}

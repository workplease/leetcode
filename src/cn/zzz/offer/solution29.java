package cn.zzz.offer;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution29 {

    /**
     * 对于每层，从左上方开始以顺时针的顺序遍历所有元素。
     *
     * 假设当前层的左上角位于 (top,left)，右下角位于 (bottom,right)，按照如下顺序遍历当前层的元素。
     *
     * 从左到右遍历上侧元素，依次为 (top,left) 到 (top,right)。
     *
     * 从上到下遍历右侧元素，依次为 (top+1,right) 到 (bottom,right)。
     *
     * 如果 left<right 且 top<bottom，则从右到左遍历下侧元素，依次为 (bottom,right−1) 到 (bottom,left+1)，
     * 以及从下到上遍历左侧元素，依次为 (bottom,left) 到 (top+1,left)。
     *
     * 遍历完当前层的元素之后，将 left 和 top 分别增加 1，将 right 和 bottom 分别减少 1，进入下一层继续遍历，直到遍历完所有元素为止。
     *
     * @param matrix
     * @return
     */
    public int[] spiralOrder(int[][] matrix) {
        //数组为空返回空数组
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length, columns = matrix[0].length;
        int[] order = new int[rows * columns];
        int index = 0;
        //矩形数组四个方位left,right,top,bottom
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            //打印第一条边
            for (int column = left; column <= right; column++) {
                order[index++] = matrix[top][column];
            }
            //打印第二条边
            for (int row = top + 1; row <= bottom; row++) {
                order[index++] = matrix[row][right];
            }
            //不止一行或者不止一列，有可能打印剩下两条边
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    order[index++] = matrix[bottom][column];
                }
                for (int row = bottom; row > top; row--) {
                    order[index++] = matrix[row][left];
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }
}

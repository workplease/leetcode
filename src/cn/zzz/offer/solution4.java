package cn.zzz.offer;

/**
 * 在一个 n * m 的二维数组中，
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 *
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 现有矩阵 matrix 如下：
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 *
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution4 {

    /**
     * 暴力解法：遍历比较
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int rowLength = matrix.length;
        int colLength = 0;
        if (rowLength > 0) {
            colLength = matrix[0].length;
        }
        int N = rowLength*colLength;
        for (int i = 0;i < colLength;i ++){
            for (int j = 0;j < rowLength;j ++){
                if (target == matrix[j][i])
                    return true;
            }
        }
        return false;
    }

    /**
     * 行从0开始，列从最大值开始，先比较此时右上角的数，如果小于该数，这一列就可以舍弃，列数减一
     * 如果大于该数，这一列就往下遍历，行数加一
     * 使得target一直是与右上角的数进行比较
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        int rowLength = matrix.length;
        int colLength = 0;
        if (rowLength > 0) {
            colLength = matrix[0].length;
        }
        int i = 0;
        while (i < rowLength && colLength > 0){
            if (target == matrix[i][colLength-1]){
                return true;
            }else if (target < matrix[i][colLength-1]){
                colLength--;
            }else if (target > matrix[i][colLength-1]){
                i++;
            }
        }
        return false;
    }
}

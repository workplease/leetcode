package cn.zzz.offer;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，
 * 因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution13 {

    public int movingCount(int m, int n, int k) {
        if(m <= 0 || n <= 0 || k < 0){
            return 0;
        }
        boolean[] visited = new boolean[m*n];
        for (int i = 0;i < m*n;i ++){
            visited[i] = false;
        }
        int count = movingCountCore(k,m,n,0,0,visited);
        return count;
    }

    /**
     * 递归调用查找函数，我们在搜索的过程中搜索方向可以缩减为向右和向下，而不必再向上和向左进行搜索。
     * @param k
     * @param rows
     * @param cols
     * @param row
     * @param col
     * @param visited
     * @return
     */
    private int movingCountCore(int k, int rows, int cols, int row, int col, boolean[] visited) {
        int count = 0;
        if (check(k,rows,cols,row,col,visited)){
            visited[row*cols + col] = true;
            count = 1 + movingCountCore(k,rows,cols,row+1,col,visited) + movingCountCore(k,rows,cols,row,col+1,visited);
        }
        return count;
    }

    /**
     * 判断函数，判断机器人能否进入坐标（row，col）
     * @return
     */
    private boolean check(int k, int rows, int cols, int row, int col, boolean[] visited){
        if (row >= 0 && row < rows && col >= 0 && col < cols && !visited[row*cols+col] && (getDigitSum(row) + getDigitSum(col) <= k)){
            return true;
        }
        return false;
    }

    /**
     * 计算位数之和
     * @param number
     * @return
     */
    private int getDigitSum(int number){
        int sum = 0;
        while (number > 0){
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}

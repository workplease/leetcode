package cn.zzz.offer;

/**
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 *
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution66 {

    /**
     * 根据表格的主对角线（全为 1 ），可将表格分为 上三角 和 下三角 两部分。
     * 分别迭代计算下三角和上三角两部分的乘积，即可 不使用除法 就获得结果。
     *
     * 初始化：数组 B ，其中 B[0] = 1；辅助变量 tmp = 1；
     * 计算 B[i] 的下三角各元素的乘积，直接乘入 B[i]；
     * 计算 B[i] 的上三角各元素的乘积，记为 tmp ，并乘入 B[i]；
     * 返回 B 。
     *
     * @param a
     * @return
     */
    public int[] constructArr(int[] a) {
        if(a.length == 0) return new int[0];
        int[] b = new int[a.length];
        b[0] = 1;
        int tmp = 1;
        //计算下三角
        for(int i = 1; i < a.length; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        //计算上三角
        for(int i = a.length - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            b[i] *= tmp;
        }
        return b;
    }
}

package cn.zzz.offer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution10_2 {

    /**
     * 把n级台阶时的跳法看成n的函数，记为f(n)，当n>2,
     * 第一次跳就有两种不同的选择：
     * 一是第一次只跳一级，此时跳法数目等于后面剩下的n-1级台阶的跳法数目，即为f(n-1)。
     * 二是第一次跳2级，此时跳法数目等于后面剩下的n-2级台阶的跳法数目，即为f(n-2)。
     * 因此，n级台阶的不同跳法的总数f(n)=f(n-1)+f(n-2)，其实就是斐波那契数列
     *
     * @param n
     * @return
     */
    public int numWays(int n) {
        int[] result = {1,1};
        if (n < 2)
            return result[n];
        int fibNMinusOne = 1;
        int fibNMinusTwo = 1;
        int fibN = 0;
        for (int i = 2;i <= n;i++){
            fibN = (fibNMinusOne + fibNMinusTwo)%1000000007;
            fibNMinusTwo = fibNMinusOne%1000000007;
            fibNMinusOne = fibN%1000000007;
        }
        return fibN;
    }
}

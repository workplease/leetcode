package cn.zzz.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 *
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 输入：n = 2
 * 输出：1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution10_1 {

    public int fib(int n) {
        return fib(n, new HashMap());
    }

    public int fib(int n, Map<Integer, Integer> map) {
        if (n < 2)
            return n;
        if (map.containsKey(n))
            return map.get(n);
        int first = fib(n - 1, map)%1000000007;
        map.put(n - 1, first);
        int second = fib(n - 2, map)%1000000007;
        map.put(n - 2, second);
        int res = (first + second)%1000000007;
        map.put(n, res);
        return res;
    }

    /**
     * 把已经得到的数列中间项保存起来，在下次需要计算的时候先查找运行，如果之前已经计算过就不用再重复计算了
     * @param n
     * @return
     */
    public int fib2(int n) {
        int[] result = {0,1};
        if(n < 2)
            return result[n];

        int fibNMinusOne = 1;
        int fibNMinusTwo = 0;
        int fibN = 0;
        for(int i = 2;i <= n;i ++){
            fibN = (fibNMinusOne + fibNMinusTwo)%1000000007;
            fibNMinusTwo = (fibNMinusOne)%1000000007;
            fibNMinusOne = (fibN)%1000000007;
        }
        return fibN;
    }
}

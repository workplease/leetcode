package cn.zzz.offer;

/**
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 * 输入: n = 3
 * 输出: 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qiu-12n-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution64 {

    int res = 0;

    /**
     * 本题需要实现 “当 n = 1n=1 时终止递归” 的需求，可通过短路效应实现。
     *
     * n > 1 && sumNums(n - 1) ： 当 n = 1 时 n > 1 不成立 ，此时 “短路” ，终止后续递归
     * @param n
     * @return
     */
    public int sumNums(int n) {
        boolean x = n > 1 && sumNums(n - 1) > 0;
        res += n;
        return res;
    }
}

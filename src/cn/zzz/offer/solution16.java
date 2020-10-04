package cn.zzz.offer;

/**
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution16 {

    /**
     * 当 x = 0 时：直接返回 0 （避免后续 x = 1 / x 操作报错）。
     * 初始化 res = 1；
     * 当 n < 0 时：把问题转化至 n≥0 的范围内，即执行 x = 1/x，n = - n；
     * 循环计算：当 n = 0 时跳出；
         * 当 n&1=1 时：将当前 x 乘入 res （即 res *= x ）；
         * 执行 x = x^2x（即 x *= x）；
         * 执行 n 右移一位（即 n >>= 1）。
     * 返回 resres 。
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if(x == 0) return 0;
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            if((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }
}

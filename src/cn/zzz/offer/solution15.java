package cn.zzz.offer;

/**
 * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 *
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution15 {

    public int hammingWeight(int n) {
        String result = Integer.toBinaryString(n);
        int sum = 0;
        for (int i = 0;i < result.length();i++){
            char ch = result.charAt(i);
            if (ch == '1'){
                sum++;
            }
        }
        return sum;
    }

    /**
     * 初始化数量统计变量 res = 0。
     * 循环逐位判断： 当 n = 0 时跳出。
     * res += n & 1 ： 若 n&1=1 ，则统计数 res 加一。
     * n >>>= 1 ： 将二进制数字 n 无符号右移一位（ Java 中无符号右移为 ">>>" ） 。
     * 返回统计数量 res 。
     *
     * @param n
     * @return
     */
    public int hammingWeight1(int n){
        int res = 0;
        while(n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }

    /**
     * 把一个整数减去1，再和原整数做与运算，会把该整数最右边的1变成0，其他逻辑与上一张情况一致。
     * @param n
     * @return
     */
    public int hammingWeight2(int n){
        int count = 0;
        while (n != 0){
            ++count;
            n = (n-1) & n;
        }
        return count;
    }
}

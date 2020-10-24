package cn.zzz.offer;

/**
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。
 * 在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 *
 * 请写一个函数，求任意第n位对应的数字。
 *
 * 输入：n = 3
 * 输出：3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution44 {

    /**
     * 1. 确定所求数位的所在数字的位数:
     * 循环执行 n 减去 一位数、两位数、... 的数位数量 count ，直至 n ≤ count 时跳出。
     * 由于 n 已经减去了一位数、两位数、...、(digit-1) 位数的 数位数量 count ，因而此时的 n 是从起始数字 start 开始计数的。
     * 结论：所求数位 ① 在某个 digit 位数中； ② 为从数字 start 开始的第 n 个数位。
     *
     * 2. 确定所求数位所在的数字:
     * 所求数位在从数字 start 开始的第 [(n - 1) / digit] 个 数字 中（ start 为第 0 个数字）
     * num = start + (n - 1) / digit
     * 结论： 所求数位在数字 num 中。
     *
     * 3. 确定所求数位在 num 的哪一数位:
     * 所求数位为数字 num 的第 (n - 1) % digit 位（数字的首个数位为第 0 位）。
     * 结论： 所求数位是 res 。
     *
     * @param n
     * @return
     */
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
    }
}

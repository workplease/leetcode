package cn.zzz.offer;

/**
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 *
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/chou-shu-lcof/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution49 {

    /**
     * 根据丑数的定义：丑数应该是另一个丑数乘以2，3，5的结果（1除外）
     * 可以创建一个数组，里面的数字为排列好的丑数，每个丑数都是前面的丑数乘以2，3，5得到的
     *
     * 假设数组中已经有若干个排好序的丑数，并且把已有最大的丑数记作 M
     *
     * 下一个丑数：
     * M2：之前每一个丑数都乘以2
     * M3：之前每一个丑数都乘以3
     * M5：之前每一个丑数都乘以5
     *
     * 上面三种情况中最小的那个就是下一个丑数，因此需要三个指针不断的移动，找到目前略大于最大值的因数
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if(dp[i] == n2) a++;
            if(dp[i] == n3) b++;
            if(dp[i] == n5) c++;
        }
        return dp[n - 1];
    }
}

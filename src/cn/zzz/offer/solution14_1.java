package cn.zzz.offer;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 *
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution14_1 {

    /**
     * 动态规划
     *
     * 当 n≤3 时，按照规则应不切分，但由于题目要求必须剪成 m>1 段，因此必须剪出一段长度为 1 的绳子，即返回 n - 1 。
     *
     * 子问题的最优解存储在数组 products 里，第 i 个元素表示把长度为 i 的绳子剪成若干段后各段长度乘积的最大值，即 f（i）
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        if (n <= 3){
            return n-1;
        }
        int[] products = new int[n+1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        int max;
        for (int i = 4;i <= n;i++){
            max = 0;
            for (int j = 1;j <= i/2;j ++){
                int product = products[j] * products[i-j];
                if (max < product)
                    max = product;
                products[i] = max;
            }
        }
        return products[n];
    }

    /**
     * 贪心算法
     *
     * 当 n≤3 时，按照规则应不切分，但由于题目要求必须剪成 m>1 段，因此必须剪出一段长度为 1的绳子，即返回 n - 1 。
     * 当 n>3 时，求 n 除以 3 的 整数部分 a 和 余数部分 b （即 n = 3a + b ），并分为以下三种情况：
     * 当 b = 0 时，直接返回 3^a
     * 当 b = 1 时，要将一个 1 + 3 转换为 2+2，因此返回 3^{a-1} * 4
     * 当 b = 2 时，返回 3^a * 2
     *
     * @param n
     * @return
     */
    public int cuttingRope1(int n) {
        if(n <= 3) return n - 1;
        int a = n / 3, b = n % 3;
        if(b == 0) return (int)Math.pow(3, a);
        if(b == 1) return (int)Math.pow(3, a - 1) * 4;
        return (int)Math.pow(3, a) * 2;
    }
}

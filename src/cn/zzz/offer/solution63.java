package cn.zzz.offer;

/**
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution63 {

    /**
     * 换个思路考虑：在卖出价固定的情况下，买入价越低获得的利润越大。
     * 也就是说，在扫描到数组中的第 i 个数字时，只要能记住之前的 i - 1 个数字中的最小值，就能算出在当前价位卖出时可能得到的最大利润。
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length < 2)
            return 0;
        int min = prices[0];
        int maxDif = prices[1] - min;
        for (int i = 2;i < prices.length;i++){
            if (prices[i - 1] < min)
                min = prices[i - 1];
            int currentDif = prices[i] - min;
            if (currentDif > maxDif)
                maxDif = currentDif;
        }
        return Math.max(maxDif, 0);
    }
}

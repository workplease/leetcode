package cn.zzz.offer;
/**
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 *
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 *
 * 输入: 1
 * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution60 {

    private final int max_Value = 6;

    public double[] dicesProbability(int n) {
        if(n < 1)
            return null;
        int[][] box = new int[2][max_Value * n + 1];
        for (int i = 0;i < max_Value * n + 1;++i){
            box[0][i] = 0;
            box[1][i] = 0;
        }
        int flag = 0;
        for (int i = 1;i <= max_Value;++i){
            box[flag][i] = 1;
        }
        for (int k = 2;k <= n;++k){
            for (int i = 0;i < k;++i){
                box[1-flag][i] = 0;
            }
            for (int i = k;i <= max_Value * k;++i){
                box[1-flag][i] = 0;
                for (int j = 1;j <= i && j <= max_Value;++j){
                    box[1-flag][i] += box[flag][i - j];
                }
            }
            flag = 1 - flag;
        }
        double total = Math.pow(max_Value,n);
        double[] answer = new double[max_Value*n - n + 1];
        for (int i = n,j = 0;i <= max_Value * n;++i,++j){
            double ratio = (double) box[flag][i]/total;
            answer[j] = ratio;
        }
        return answer;
    }

    /**
     * 1.构造dp数组：tmp[] 为 n 个骰子的点数概率数组，pre[] 为 n-1 个骰子的点数概率数组，
     *              一个骰子的点数概率数组显然是 6个六分之一,不需要另设数组。
     *
     * 2.初始化dp数组：pre[]={1/6d,1/6d,1/6d,1/6d,1/6d,1/6d}
     *
     * 3.构造状态转移方程:tmp[x+y]+=pre[x]*num[y];
     *
     * @param n
     * @return
     */
    public double[] dicesProbability1(int n) {
        double pre[]={1/6d,1/6d,1/6d,1/6d,1/6d,1/6d};
        for(int i=2;i<=n;i++){
            double tmp[]=new double[5*i+1];
            for(int j=0;j<pre.length;j++)
                for(int x=0;x<6;x++)
                    tmp[j+x]+=pre[j]/6;
            pre=tmp;
        }
        return pre;
    }
}

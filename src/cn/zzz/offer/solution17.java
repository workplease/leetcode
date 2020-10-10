package cn.zzz.offer;

/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution17 {

    /**
     * 大数越界情况下的打印。需要解决以下三个问题：
     *
     * 1. 表示大数的变量类型：
     * 无论是 short / int / long ... 任意变量类型，数字的取值范围都是有限的。因此，大数的表示应用字符串 String 类型。
     * 2. 生成数字的字符串集：
     * 使用 int 类型时，每轮可通过 +1 生成下个数字，而此方法无法应用至 String 类型。
     * 并且， String 类型的数字的进位操作效率较低，例如 "9999" 至 "10000" 需要从个位到千位循环判断，进位 4 次。
     *
     * 观察可知，生成的列表实际上是 n 位 0 - 9 的 全排列 ，因此可避开进位操作，通过递归生成数字的 String 列表。
     *
     * 3. 递归生成全排列：
     * 基于分治算法的思想，先固定高位，向低位递归，当个位已被固定时，添加数字的字符串。
     * 例如当 n = 2 时（数字范围 1 - 99），固定十位为 0 - 9 ，按顺序依次开启递归，固定个位 0 - 9 ，终止递归并添加数字字符串。
     *
     * 1. 删除高位多余的 00 ：
     * 字符串左边界定义： 声明变量 start 规定字符串的左边界，以保证添加的数字字符串 num[start:] 中无高位多余的 0 。
     * 例如当 n = 2 时， 1 - 9 时 start = 1 ， 10 - 99 时 start = 0 。
     *
     * 左边界 start 变化规律： 观察可知，当输出数字的所有位都是 9 时，则下个数字需要向更高位进 1 ，
     * 此时左边界 start 需要减 1 （即高位多余的 0 减少一个）。
     *
     * 例如当 n = 3 （数字范围 1 - 999 ）时，左边界 start 需要减 1 的情况有： "009" 进位至 "010" ， "099" 进位至 "100" 。
     * 设数字各位中 99 的数量为 nine ，所有位都为 9 的判断条件可用以下公式表示：
     * n - start = nine
     *
     * 统计 nine 的方法： 固定第 x 位时，当 i = 9 则执行 nine = nine + 1，并在回溯前恢复 nine = nine - 1 。
     *
     * 2. 列表从 1 开始：
     * 在以上方法的基础上，添加数字字符串前判断其是否为 "0" ，若为 "0" 则直接跳过。
     *
     */
    int[] res;
    int nine = 0, count = 0, start, n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public int[] printNumbers(int n) {
        this.n = n;
        res = new int[(int)Math.pow(10, n) - 1];
        num = new char[n];
        start = n - 1;
        dfs(0);
        return res;
    }
    void dfs(int x) {
        if(x == n) {
            String s = String.valueOf(num).substring(start);
            if(!s.equals("0")) res[count++] = Integer.parseInt(s);
            if(n - start == nine) start--;
            return;
        }
        for(char i : loop) {
            if(i == '9') nine++;
            num[x] = i;
            dfs(x + 1);
        }
        nine--;
    }
}

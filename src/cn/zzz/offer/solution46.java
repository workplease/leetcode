package cn.zzz.offer;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution46 {

    public int translateNum(int num) {
        if (num < 0)
            return 0;
        String s = String.valueOf(num);
        return GetTranslationCount(s);
    }

    /**
     * 从右到左进行进行翻译，防止出现重复子问题
     * @param s
     * @return
     */
    private int GetTranslationCount(String s) {
        int length = s.length();
        int[] counts = new int[length];
        int count = 0;

        for (int i = length - 1;i >= 0;i--){
            count = 0;
            if (i < length - 1)
                count = counts[i+1];
            else
                count = 1;
            if (i < length - 1){
                int digit1 = s.charAt(i) - '0';
                int digit2 = s.charAt(i+1) - '0';
                int converted = digit1 * 10 + digit2;
                if (converted >= 10 && converted <= 25){
                    if (i < length - 2)
                        count += counts[i+2];
                    else
                        count += 1;
                }
            }
            counts[i] = count;
        }
        count = counts[0];
        return count;
    }
}

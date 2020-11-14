package cn.zzz.offer;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 *
 * 输入: a = 1, b = 1
 * 输出: 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution65 {

    /**
     * 使用位运算实现加法功能：难点在于进位。
     * 原位和：a^b ： 1^1 = 0,1^0 = 1,0^1 = 1,0^0 = 0
     * 进位和：(a&b)<<1： 只有但ab都为1的时候会进位，并且这个时候进位需要在后面补上0
     * 加上判断语句：如果有进位，就进位和 + 原位和；如果没有进位，直接等于原位和
     * @param a
     * @param b
     * @return
     */
    public int add(int a, int b) {
        int res=a;
        int xor=a^b;//得到原位和
        int forward=(a&b)<<1;//得到进位和
        if(forward!=0){//若进位和不为0，则递归求原位和+进位和
            res=add(xor, forward);
        }else{
            res=xor;//若进位和为0，则此时原位和为所求和
        }
        return res;
    }
}

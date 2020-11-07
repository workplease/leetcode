package cn.zzz.offer;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。
 *
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution58_2 {

    /**
     * 先对所求长度取余，获得最短的长度偏移要求
     * 将字符串的长度扩展为两倍，保证不管是偏移多少，结果都是其字串
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        if (s == null)
            return null;
        n = n % s.length();
        if (n == 0)
            return s;
        StringBuffer sb = new StringBuffer(s);
        sb.append(s);
        return sb.substring(n,s.length() + n);
    }
}

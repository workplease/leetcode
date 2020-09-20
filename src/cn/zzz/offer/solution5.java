package cn.zzz.offer;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution5 {

    public String replaceSpace(String s) {
        int length = s.length();
        char[] Array = new char[length*3];
        int size = 0;
        for (int i = 0;i < length;i++){
            char c = s.charAt(i);
            if (c == ' '){
                Array[size++] = '%';
                Array[size++] = '2';
                Array[size++] = '0';
            }else {
                Array[size++] = s.charAt(i);
            }
        }
        String newStr = new String(Array,0,size);
        return newStr;
    }
}

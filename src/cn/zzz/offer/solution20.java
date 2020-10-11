package cn.zzz.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，
 * 但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution20 {

    public boolean isNumber(String s) {
        //空字符为false
        if(s==null||s.length()==0) return false;
        boolean isNum = false,isDot = false,ise_or_E = false;
        //去除前面的空格
        char[] str = s.trim().toCharArray();
        for(int i=0;i<str.length;i++){
            if(str[i] >= '0' && str[i] <= '9')
                isNum = true;
            else if(str[i] == '.'){
                //'.'之前有'.'或者'e'都为false
                if(isDot || ise_or_E) return false;
                isDot = true;
            }
            else if(str[i] == 'e' || str[i] == 'E'){
                //'e'前面没有数字或者有'e'的为false
                if(!isNum || ise_or_E) return false;
                ise_or_E = true;
                //出现e后，将num的判断置于false，以便后面进行下一步判断
                isNum = false;
            }
            else if(str[i] == '-' || str[i] == '+'){
                //符号不在首位或者不在'e'后面，为false
                if(i != 0 && str[i-1]!='e' && str[i-1]!='E') return false;
            }
            else return false;
        }
        //最后对num进行判断
        return isNum;
    }
}

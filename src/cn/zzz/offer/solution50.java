package cn.zzz.offer;

import com.sun.deploy.security.SelectableSecurityManager;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * s = "abaccdeff"
 * 返回 "b"
 *
 * s = ""
 * 返回 " "
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution50 {

    public char firstUniqChar(String s) {
        if (s.length() == 0 || s == null)
            return ' ';
        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();
        int length = s.length();
        int rk = -1;//右指针
        while (rk + 1 < length) {
            // 不断地移动右指针
            set1.add(s.charAt(rk + 1));
            set2.add(s.charAt(rk + 1));
            ++rk;
        }
        for (int i = 0;i < length;i++){
            char c = s.charAt(i);
            if (set1.contains(c)){
                if (set2.contains(c)){
                    set2.remove(c);
                }else{
                    set1.remove(c);
                }
            }
        }
        if (set1.isEmpty())
            return ' ';
        for (int i = 0;i < length;i ++){
            char c = s.charAt(i);
            if (set1.contains(c)){
                return c;
            }
        }
        return ' ';
    }

    /**
     * 字符统计： 遍历字符串 s 中的每个字符 c ；
     * 若 dic 中 不包含 键(key) c ：则向 dic 中添加键值对 (c, True) ，代表字符 c 的数量为 1 ；
     * 若 dic 中 包含 键(key) c ：则修改键 c 的键值对为 (c, False) ，代表字符 c 的数量 >1 。
     * 查找数量为 1 的字符： 遍历字符串 s 中的每个字符 c ；
     * 若 dic 中键 c 对应的值为 True ：，则返回 c 。
     * 返回 ' ' ，代表字符串无数量为 1 的字符。
     *
     * @param s
     * @return
     */
    public char firstUniqChar1(String s) {
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc)
            dic.put(c, !dic.containsKey(c));
        for(char c : sc)
            if(dic.get(c)) return c;
        return ' ';
    }
}

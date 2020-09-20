package cn.zzz.leetcode.Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 *  s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 *
 *来源：力扣（LeetCode）
 *链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 *著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution387 {

    public int firstUniqChar(String s) {
        int[] nums = new int[26];
        for (int i = 0;i < s.length();i++){
            nums[s.charAt(i) - 'a'] ++;
        }
        for (int i = 0;i < s.length();i ++){
            if (nums[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }

    /**
     * 优化算法，关键是其中两步
     * 1. 将字符在字符串s中的索引与倒数一个索引做对比，如果一致，就是独立的。
     * 2. 每次判断的时候多加一个条件，要比之前的索引小，这样能保证查找到的索引是最小的。
     *
     * @param s
     * @return
     */
    public int firstUniqChar1(String s) {
        int length = s.length();
        for (char c = 'a';c <= 'z';c++){
            int index = s.indexOf(c);
            length =  (index != -1 && index < length && index == s.lastIndexOf(c)) ? index : length;
        }
        return (length == s.length()) ? -1:length;
    }
}

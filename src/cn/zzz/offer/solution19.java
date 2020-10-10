package cn.zzz.offer;

/**
 * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
 *
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution19 {

    /**
     * 假设主串为 A，模式串为 B 从最后一步出发，需要关注最后进来的字符。
     * 假设 A 的长度为 n ，B 的长度为 m ，关注正则表达式 B 的最后一个字符是谁，
     * 它有三种可能，正常字符、*∗ 和 .（点），那针对这三种情况讨论即可，如下：
     *
     * 如果 B 的最后一个字符是正常字符，那就是看 A[n-1] 是否等于 B[m-1]，相等则看 A_{0..n-2}与 B_{0..m-2}，不等则是不能匹配，这就是子问题。
     *
     * 如果 B 的最后一个字符是'.'，它能匹配任意字符，直接看 A_{0..n-2}与 B_{0..m-2}​
     *
     * 如果 B 的最后一个字符是'*',它代表 B[m-2]=c 可以重复0次或多次，它们是一个整体 c*
     *
     * 情况一：A[n-1] 是 0 个 c，B 最后两个字符废了，能否匹配取决于 A_{0..n-1}和 B_{0..m-3}是否匹配
     *
     * 情况二：A[n-1] 是多个 c 中的最后一个（这种情况必须 A[n-1]=cA[n−1]=c 或者 c='.'），
     * 所以 A 匹配完往前挪一个，B 继续匹配，因为可以匹配多个，继续看 A_{0..n-2}和 B_{0..m-1}是否匹配。
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] f = new boolean[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                //分成空正则和非空正则两种
                if (j == 0) {
                    f[i][j] = i == 0;
                } else {
                    //非空正则分为两种情况 * 和 非*
                    if (p.charAt(j - 1) != '*') {
                        if (i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
                            f[i][j] = f[i - 1][j - 1];
                        }
                    } else {
                        //碰到 * 了，分为看和不看两种情况
                        //不看
                        if (j >= 2) {
                            f[i][j] |= f[i][j - 2];
                        }
                        //看
                        if (i >= 1 && j >= 2 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) {
                            f[i][j] |= f[i - 1][j];
                        }
                    }
                }
            }
        }
        return f[n][m];
    }

    public boolean isMatch1(String s,String p){
        // 如果字符串长度为0，需要检测下正则串
        if (s.length() == 0) {
            // 如果正则串长度为奇数，必定不匹配，比如 "."、"sb*",必须是 s*b*这种形式，*在奇数位上
            if (p.length() % 2 != 0) return false;
            int i = 1;
            while (i < p.length()) {
                if (p.charAt(i) != '*') return false;
                i += 2;
            }
            return true;
        }
        // 如果字符串长度不为0，但是正则串没了，return false
        if (p.length() == 0) return false;
        // c1 和 c2 分别是两个串的当前位，c3是正则串当前位的后一位，如果存在的话，就更新一下
        char c1 = s.charAt(0), c2 = p.charAt(0), c3 = 'a';
        if (p.length() > 1) {
            c3 = p.charAt(1);
        }
        // 和dp一样，后一位分为是 '*' 和不是 '*' 两种情况
        if (c3 != '*') {
            // 如果该位字符一样，或是正则串该位是 '.',也就是能匹配任意字符，就可以往后走
            if (c1 == c2 || c2 == '.') {
                return isMatch1(s.substring(1), p.substring(1));
            } else {
                // 否则不匹配
                return false;
            }
        } else {
            // 如果该位字符一样，或是正则串该位是 '.'，和dp一样，有看和不看两种情况
            if (c1 == c2 || c2 == '.') {
                return isMatch1(s.substring(1), p) || isMatch1(s, p.substring(2));
            } else {
                // 不一样，那么正则串这两位就废了，直接往后走
                return isMatch1(s, p.substring(2));
            }
        }
    }
}

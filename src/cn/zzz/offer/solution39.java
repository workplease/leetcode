package cn.zzz.offer;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution39 {

    /**
     * 算法原理：
     * 为构建正负抵消，假设数组首个元素 n_1为众数，遍历统计票数，当发生正负抵消时，剩余数组的众数一定不变 ，这是因为（设真正的众数为 x ）：
     * 当 n_1 = x： 抵消的所有数字中，有一半是众数 x 。
     * 当 n_1 不等于 x
     *
     * 算法流程：
     * 初始化： 票数统计 votes = 0 ， 众数 x；
     * 循环抵消： 遍历数组 nums 中的每个数字 num ；
     * 当 票数 votes 等于 0 ，则假设 当前数字 num 为 众数 x ；
     * 当 num = x 时，票数 votes 自增 11 ；否则，票数 votes 自减 1 。
     * 返回值： 返回 众数 x 即可。
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int x = 0, votes = 0;
        for(int num : nums){
            if(votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }
}

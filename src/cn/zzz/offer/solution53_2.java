package cn.zzz.offer;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 * 输入: [0,1,3]
 * 输出: 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution53_2 {

    /**
     * 初始化： 左边界 i = 0 ，右边界 j = len(nums) - 1 ；代表闭区间 [i, j]。
     * 循环二分： 当 i ≤ j 时循环 （即当闭区间 [i, j]为空时跳出） ；
     * 计算中点 m = (i + j) / 2 ，其中 "/" 为向下取整除法；
     * 若 nums[m] = m ，则 “右子数组的首位元素” 一定在闭区间 [m + 1, j] 中，因此执行 i = m + 1；
     * 若 nums[m] 不等于 m ，则 “左子数组的末位元素” 一定在闭区间 [i, m - 1] 中，因此执行 j = m - 1；
     * 返回值： 跳出时，变量 i 和 j 分别指向 “右子数组的首位元素” 和 “左子数组的末位元素” 。因此返回 i 即可。
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] == m) i = m + 1;
            else j = m - 1;
        }
        return i;
    }
}

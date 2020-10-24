package cn.zzz.offer;

/**
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution42 {

    /**
     * 定义两个变量，一个记录当前的和，一个记录目前最大的值
     *
     * nCurNum：
     * 当目前和小于零时，相当于前面的值是负担，可以舍弃，即更新当前和的数值
     * 当当前和大于零时，加上目前的数值
     *
     * nGreatestNum:
     * 当目前和大于该值时，就更新该值
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int nCurSum = 0;
        int nGreatestSum = 0x80000000;
        for (int i = 0;i < nums.length;i++){
            if (nCurSum <= 0)
                nCurSum = nums[i];
            else
                nCurSum += nums[i];

            if (nCurSum > nGreatestSum)
                nGreatestSum = nCurSum;
        }
        return nGreatestSum;
    }
}

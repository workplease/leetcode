package cn.zzz.offer;

import java.util.HashMap;

/**
 * 统计一个数字在排序数组中出现的次数。
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution53_1 {

    public int search(int[] nums, int target) {
        if (nums == null)
            return 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums){
            if(!map.containsKey(num)){
                map.put(num,1);
            }else {
                map.put(num,map.get(num) + 1);
            }
        }
        if (map.containsKey(target)){
            return map.get(target);
        }
        return 0;
    }

    /**
     * 初始化： 左边界 i = 0 ，右边界 j = len(nums) - 1 。
     *
     * 循环二分： 当闭区间 [i, j] 无元素时跳出；
     * 计算中点 m = (i + j) / 2 （向下取整）；
     * 若 nums[m] < target ，则 target 在闭区间 [m + 1, j] 中，因此执行 i = m + 1；
     * 若 nums[m] > target ，则 target 在闭区间 [i, m - 1] 中，因此执行 j = m - 1；
     * 若 nums[m] = target ，则右边界 right 在闭区间 [m + 1, j] 中；左边界 left 在闭区间 [i, m - 1] 中。因此分为以下两种情况：
     * 若查找 右边界 right ，则执行 i = m + 1 ；（跳出时 i 指向右边界）
     * 若查找 左边界 left ，则执行 j = m - 1 ；（跳出时 j 指向左边界）
     *
     * 返回值： 应用两次二分，分别查找 right 和 left ，最终返回 right - left - 1 即可。
     *
     * @param nums
     * @param target
     * @return
     */
    public int search1(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }

    int helper(int[] nums, int tar) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] <= tar) i = m + 1;
            else j = m - 1;
        }
        return i;
    }
}

package cn.zzz.offer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。
 * A 不能视为 14。
 *
 * 输入: [1,2,3,4,5]
 * 输出: True
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution61 {

    /**
     * 逻辑：首先判断是否超出数据大小和是否有重复，有则不连续，
     * 然后找出三个值，最大值，最小值，和 0 的个数，一旦最大值和最小值的差值超过 0 的个数加上 4 就不是连续的。
     * @param nums
     * @return
     */
    public boolean isStraight(int[] nums) {
        if (!isNotNormal(nums) || !isRepeat(nums))
            return false;
        int max = findMax(nums);
        int min = findMin(nums);
        int zeroNum = zeroNums(nums);
        if (zeroNum + min + 4>= max){
            return true;
        }
        return false;
    }

    private int findMax(int[] nums){
        int max = nums[0];
        for (int i = 0;i < nums.length;i ++){
            if (nums[i] > max)
                max = nums[i];
        }
        return max;
    }

    private int findMin(int[] nums){
        int min = nums[0];
        for (int i = 0;i < nums.length;i ++){
            if ((nums[i] < min && nums[i] != 0 )||min == 0)
                min = nums[i];
        }
        return min;
    }

    private boolean isRepeat(int[] nums){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length;i ++){
            if (map.containsKey(nums[i]) && nums[i] != 0){
                map.put(nums[i],2);
                return false;
            }else {
                map.put(nums[i], 1);
            }
        }
        return true;
    }

    private int zeroNums(int[] nums){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length;i ++){
            if (map.containsKey(0)){
                map.put(nums[i],map.get(0) + 1);
            }else {
                map.put(nums[i], 1);
            }
        }
        if (map.containsKey(0)){
            return map.get(0);
        }
        return 0;
    }

    private boolean isNotNormal(int[] nums){
        for (int i = 0;i < nums.length;i++){
            if (nums[i] < 0 || nums[i] > 13)
                return false;
        }
        return true;
    }
}

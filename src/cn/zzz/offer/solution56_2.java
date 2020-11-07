package cn.zzz.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 *
 * 输入：nums = [3,4,3,3]
 * 输出：4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution56_2 {

    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length;i++){
            if (map.containsKey(nums[i])){
                map.put(nums[i],3);
            }else {
                map.put(nums[i],1);
            }
        }
        for (int i : map.keySet()){
            if (map.get(i) == 1)
                return i;
        }
        return 0;
    }

    /**
     * 各二进制位的 位运算规则相同 ，因此只需考虑一位即可。
     *
     * 对于所有数字中的某二进制位 1 的个数，存在 3 种状态，即对 3 余数为 0, 1, 2。
     *
     * 若输入二进制位 1 ，则状态按照以下顺序转换；00 -> 01 -> 10 -> 00
     * 若输入二进制位 0 ，则状态不变。
     *
     * @param nums
     * @return
     */
    public int singleNumber1(int[] nums){
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }
}


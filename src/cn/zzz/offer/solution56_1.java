package cn.zzz.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution56_1 {

    public int[] singleNumbers(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length;i++){
            if (map.containsKey(nums[i])){
                map.put(nums[i],2);
            }else {
                map.put(nums[i],1);
            }
        }
        int answer[] = new int[2];
        for (int i : map.keySet()){
            if (map.get(i) == 1){
                if (answer[0] <= 0)
                    answer[0] = i;
                else{
                    answer[1] = i;
                    break;
                }
            }
        }
        return answer;
    }

    /**
     * 先对所有数字进行一次异或，得到两个出现一次的数字的异或值。
     *
     * 在异或结果中找到任意为 11 的位。
     *
     * 根据这一位对所有的数字进行分组。
     *
     * 在每个组内进行异或操作，得到两个数字。
     *
     * @param nums
     * @return
     */
    public int[] singleNumbers1(int[] nums) {
        int ret = 0;
        for (int n : nums) {
            ret ^= n;
        }
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }
        int a = 0, b = 0;
        for (int n : nums) {
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }
}

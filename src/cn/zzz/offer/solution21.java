package cn.zzz.offer;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution21 {

    /**
     * 双指针：first从前面向下索引，last从后面向上索引，一旦first指向偶数就停止，last指向奇数就停止，当两者都停止时进行交换
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        int first = 0;
        int last = nums.length - 1;
        while (first < last){
            while (first < last && (nums[first] % 2 != 0)){
                first++;
            }
            while (first < last && (nums[last] % 2 == 0)){
                last--;
            }
            if (first < last){
                exchange(nums,first,last);
            }
        }
        return nums;
    }

    private void exchange(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

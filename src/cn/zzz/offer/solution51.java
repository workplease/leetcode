package cn.zzz.offer;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 * 输入: [7,5,6,4]
 * 输出: 5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution51 {

    /**
     * 先把数组分隔成子数组，统计出子数组内部的逆序对的数目
     * 然后再统计出两个相邻子数组直接的逆序对的数目
     * 在统计的过程中，还需要对数组进行排序
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length <= 0)
            return 0;
        int[] copy = new int[nums.length];
        for (int i = 0;i < nums.length;i ++){
            copy[i] = nums[i];
        }
        return InvertPairsCore(nums,copy,0,nums.length - 1);
    }

    private int InvertPairsCore(int[] nums, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = nums[start];
            return 0;
        }
        int length = (end - start)/2;

        int left = InvertPairsCore(copy,nums,start,start + length);
        int right = InvertPairsCore(copy,nums,start + length + 1,end);

        int i = start + length;
        int j = end;
        int indexCopy = end;
        int count = 0;
        while (i >= start && j >= start + length + 1){
            if (nums[i] > nums[j]){
                copy[indexCopy --] = nums[i --];
                count += j - start - length;
            }else {
                copy[indexCopy --] = nums[j --];
            }
        }
        for (;i >= start;--i)
            copy[indexCopy --] = nums[i];
        for (;j >= start + length + 1;--j)
            copy[indexCopy --] = nums[j];
        return left + right + count;
    }
}

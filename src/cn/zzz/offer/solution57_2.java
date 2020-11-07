package cn.zzz.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution57_2 {

    /**
     * 首先初始化 left 为1，right 为2.
     * 如果从 left 到 right 的序列的和大于 x，就可以从序列中去掉较小的值，也就是增大 left 的值
     * 如果从 left 到 right 的序列的和小于 x，就可以让序列包含更多的数字，也就是增大 right 的值
     *
     * 因为这个序列至少要有两个数字，我们一直增加 left 到 right
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        List<int[]> vec = new ArrayList<int[]>();
        for (int left = 1, right = 2; left < right;) {
            int sum = (left + right) * (right - left + 1) / 2;
            if (sum == target) {
                int[] res = new int[right - left + 1];
                for (int i = left; i <= right; ++i) {
                    res[i - left] = i;
                }
                vec.add(res);
                left++;
            } else if (sum < target) {
                right++;
            } else {
                left++;
            }
        }
        return vec.toArray(new int[vec.size()][]);
    }
}

package cn.zzz.offer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 */
public class solution40 {

    /**
     * 第一种解法：直接排序
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] array = new int[k];
        Arrays.sort(arr);
        for (int i = 0;i < k;i++){
            array[i] = arr[i];
        }
        return array;
    }

    /**
     * 我们用一个大根堆实时维护数组的前 k 小值。
     * 首先将前 k 个数插入大根堆中，随后从第 k+1 个数开始遍历，
     * 如果当前遍历到的数比大根堆的堆顶的数要小，就把堆顶的数弹出，
     * 再插入当前遍历到的数。最后将大根堆里的数存入数组返回即可。
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers1(int[] arr, int k) {
        int[] vec = new int[k];
        if (k == 0) { // 排除 0 的情况
            return vec;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });
        for (int i = 0; i < k; ++i) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; ++i) {
            if (queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; ++i) {
            vec[i] = queue.poll();
        }
        return vec;
    }
}

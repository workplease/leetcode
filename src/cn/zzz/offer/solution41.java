package cn.zzz.offer;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 * 例如，
 *
 * [2,3,4] 的中位数是 3
 *
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 *
 * ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
 * [[],[1],[2],[],[3],[]]
 * 输出：[null,null,null,1.50000,null,2.00000]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution41 {

    /**
     * 算法流程：
     *
     * 设元素总数为 N = m + n，其中 m 和 n 分别为 A 和 B 中的元素个数。
     *
     * addNum(num) 函数：
     *
     * 当 m = n（即 N 为 偶数）：需向 A 添加一个元素。
     * 实现方法：将新元素 num 插入至 B ，再将 B 堆顶元素插入至 A ；
     *
     * 当 m 不等于 n（即 N 为 奇数）：需向 B 添加一个元素。
     * 实现方法：将新元素 num 插入至 A ，再将 A 堆顶元素插入至 B ；
     *
     * 假设插入数字 num 遇到情况 1. 。
     * 由于 num 可能属于 “较小的一半” （即属于 B ），因此不能将 nums 直接插入至 A 。
     * 而应先将 num 插入至 B ，再将 B 堆顶元素插入至 A 。
     * 这样就可以始终保持 A 保存较大一半、 B 保存较小一半。
     *
     *
     * findMedian() 函数：
     *
     * 当 m = n（ N 为 偶数）：则中位数为 ( A 的堆顶元素 + B 的堆顶元素 )/2。
     * 当 m 不等于 n（ N 为 奇数）：则中位数为 A 的堆顶元素。
     *
     */
    Queue<Integer> A, B;
    public solution41() {
        A = new PriorityQueue<>(); // 小顶堆，保存较大的一半
        B = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆，保存较小的一半
    }
    public void addNum(int num) {
        if(A.size() != B.size()) {
            A.add(num);
            B.add(A.poll());
        } else {
            B.add(num);
            A.add(B.poll());
        }
    }
    public double findMedian() {
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }
}



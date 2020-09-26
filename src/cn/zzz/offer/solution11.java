package cn.zzz.offer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 *
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。 
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution11 {

    public int minArray(int[] numbers) {
        int N = numbers.length;
        boolean flag = false;
        int i;
        for (i = 0;i < N;i++){
            if (i < N-1 && less(numbers[i],numbers[i+1])){
                flag = true;
                break;
            }
        }
        if (flag) {
            return numbers[i + 1];
        }else {
            return numbers[0];
        }
    }

    private boolean less(int left,int right){
        return left > right;
    }

    public int minArray1(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (numbers[pivot] < numbers[high]) {
                high = pivot;
            } else if (numbers[pivot] > numbers[high]) {
                low = pivot + 1;
            } else {
                /**
                 * 第三种情况是 numbers[pivot] == numbers[high]
                 * 由于重复元素的存在，我们并不能确定 numbers[pivot] 究竟在最小值的左侧还是右侧，
                 * 因此我们不能莽撞地忽略某一部分的元素。我们唯一可以知道的是，由于它们的值相同，
                 * 所以无论 numbers[high] 是不是最小值，都有一个它的「替代品」numbers[pivot]，
                 * 因此我们可以忽略二分查找区间的右端点。
                 */
                high -= 1;
            }
        }
        return numbers[low];
    }
}

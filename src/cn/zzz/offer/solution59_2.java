package cn.zzz.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，
 * 要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 *
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 *
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution59_2 {

    Queue<Integer> queue;
    LinkedList<Integer> max;
    public solution59_2() {
        queue = new LinkedList<>();
        max = new LinkedList<>();//LinkedList是双端链表
    }

    public int max_value() {
        return max.size() == 0 ? -1 : max.getFirst();
    }

    public void push_back(int value) {
        queue.add(value);
        while(max.size() != 0 && max.getLast() < value){//注意：这里第二个判断条件不能带等号，即max中对于当前queue中的具有相同值的元素会全部存储，而不是存储最近的那个。
            max.removeLast();
        }
        max.add(value);
    }

    public int pop_front() {
        if(max.size() != 0 && queue.peek().equals(max.getFirst()))//Integer类型的值的比较不能直接使用==
            max.removeFirst();
        return queue.size() == 0 ? -1 : queue.poll();
    }
}

package cn.zzz.offer;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();   --> 返回 0.
 * minStack.min();   --> 返回 -2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution30 {

    /**
     * push(x) 函数： 重点为保持栈 B 的元素是 非严格降序 的。
     * 将 x 压入栈 A （即 A.add(x) ）；
     * 若栈 B 为空 或  x 小于等于栈 B 的栈顶元素，则将 x 压入栈 B （即 B.add(x) ）。
     *
     * pop() 函数： 重点为保持栈 A, B 的元素一致性 。
     * 执行栈 A 出栈（即 A.pop() ），将出栈元素记为 y ；
     * 若 y 等于栈 B 的栈顶元素，则执行栈 B 出栈（即 B.pop() ）。
     *
     * top() 函数： 直接返回栈 A 的栈顶元素即可，即返回 A.peek() 。
     *
     * min() 函数： 直接返回栈 B 的栈顶元素即可，即返回 B.peek() 。
     *
     */
    Stack<Integer> A, B;
    public solution30() {
        A = new Stack<>();
        B = new Stack<>();
    }
    public void push(int x) {
        A.add(x);
        if(B.empty() || B.peek() >= x)
            B.add(x);
    }
    public void pop() {
        if(A.pop().equals(B.peek()))
            B.pop();
    }
    public int top() {
        return A.peek();
    }
    public int min() {
        return B.peek();
    }
}

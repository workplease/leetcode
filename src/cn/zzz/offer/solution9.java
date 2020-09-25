package cn.zzz.offer;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution9 {

    /**
     * 如果使用Stack的方式来做这道题，会造成速度较慢；
     * 原因的话是Stack继承了Vector接口，而Vector底层是一个Object[]数组，那么就要考虑空间扩容和移位的问题了。
     * 可以使用LinkedList来做Stack的容器，因为LinkedList实现了Deque接口，
     * 所以Stack能做的事LinkedList都能做，其本身结构是个双向链表，扩容消耗少。
     */
    private LinkedList<Integer> stack1;
    private LinkedList<Integer> stack2;

    /**
     * 根据栈先进后出的特性，我们每次往第一个栈里插入元素后，
     * 第一个栈的底部元素是最后插入的元素，第一个栈的顶部元素是下一个待删除的元素。
     * 为了维护队列先进先出的特性，我们引入第二个栈，用第二个栈维护待删除的元素，
     * 在执行删除操作的时候我们首先看下第二个栈是否为空。如果为空，
     * 我们将第一个栈里的元素一个个弹出插入到第二个栈里，这样第二个栈里元素的顺序就是待删除的元素的顺序，
     * 要执行删除操作的时候我们直接弹出第二个栈的元素返回即可。
     *
     */
    public solution9() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()){
            return -1;
        }else{
            return stack2.pop();
        }
    }
}

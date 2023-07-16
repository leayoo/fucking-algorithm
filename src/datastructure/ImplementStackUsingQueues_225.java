package datastructure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Leeyoa
 * @description:
 * @date: 2023/7/16 19:50
 */
public class ImplementStackUsingQueues_225 {
    class MyStack {
        Queue<Integer> q = new LinkedList<>();
        int top_elem = 0;


        /** 添加元素到栈顶 */
        public void push(int x){
            q.offer(x);
            top_elem = x;
        }

        /** 删除栈顶的元素并返回 */
        public int pop(){
            int size = q.size();
            while(size > 2){
                q.offer((q.poll()));
                size--;
            }
            top_elem = q.peek();
            q.offer(q.poll());
            return q.poll();
        }

        /** 返回栈顶元素 */
        public int top(){
            return top_elem;
        }

        /** 判断栈是否为空 */
        public boolean empty(){
            return q.isEmpty();
        }
    }

}

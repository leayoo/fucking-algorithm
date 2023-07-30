package datastructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: Leeyoa
 * @description:
 * @date: 2023/7/30 14:11
 */
public class SlidingWindowMaximum_239 {
    int[] maxSlidingWindow(int[] nums, int k) {
        MonotionicQueue window = new MonotionicQueue();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                // 先把窗口的前 k-1 填满
                window.push(nums[i]);
            } else {
                // 窗口开始滑动
                // 移入新元素
                window.push(nums[i]);
                // 将当前窗口中的最大元素记录结果
                res.add(window.max());
                // 移除最后的元素
                window.pop(nums[i - k + 1]);
            }
        }
        // 将List类型转化为 int[] 数组作为返回值
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;

    }

    class MonotionicQueue {
        private LinkedList<Integer> maxq = new LinkedList<>();

        // 在队尾添加元素 n
        void push(int n){
            while(!maxq.isEmpty() && maxq.getLast() < n){
                maxq.pollLast();
            }
            maxq.addLast(n);
        }

        // 返回当前队列中的最大值
        int max(){
            return maxq.getFirst();
        }

        // 队头元素如果是 n, 删除它
        void pop(int n){
            if (n== maxq.getFirst()){
                maxq.pollFirst();
            }
        }
    }
}

package datastructure;

import java.util.Stack;

/**
 * @author: Leeyoa
 * @description:
 * @date: 2023/7/30 13:57
 */
public class DailyTemperatures_739 {
    int[] dailyTemperature(int[] temperatures){
        int n = temperatures.length;
        int[] res = new int[n];
        // 这里放元素索引，而不是元素
        Stack<Integer> s = new Stack<>();
        // 单调栈模板
        for (int i=n-1; i>=0; i--){
            while(!s.isEmpty() && temperatures[s.peek()] <= temperatures[i]){
                s.pop();
            }
            // 得到索引间距
            res[i] = s.isEmpty() ? 0 : (s.peek() - i);
            // 将索引入栈，而不是元素
            s.push(i);
        }
        return res;
    }
}

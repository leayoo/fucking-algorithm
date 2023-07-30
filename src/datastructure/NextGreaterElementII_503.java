package datastructure;

import java.util.Stack;

/**
 * @author: Leeyoa
 * @description:
 * @date: 2023/7/30 13:05
 */

// 环形数组
public class NextGreaterElementII_503 {
    // 一般通过 % 运算符求模，来模拟环形特效
//    int[] arr = {1,2,3,4,5};
//    int n = arr.length;
//    int index = 0;
//    while (true){
//        print(arr[index%n]);
//        index++;
//    }

    int[] nextGreaterElements(int[] nums){
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();
        // 数组长度加倍模拟环形数组
        for (int i= 2*n-1;i>=0;i--){
            // 索引 i 要求模，其他的和模板一样
            while(!s.isEmpty() && s.peek() <= nums[i%n]){
                s.pop();
            }
            res[i%n]=s.isEmpty() ? -1 :s.peek();
            s.push(nums[i%n]);
        }
        return res;
    }
}

package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: Leeyoa
 * @description:
 * @date: 2023/7/14 9:19
 */

// 组合
public class Combinations_77 {
    List<List<Integer>> res = new LinkedList<>();

    // 记录回溯算法的递归路径
    LinkedList<Integer> track = new LinkedList<>();

    // 主函数
    public List<List<Integer>> combine(int n, int k){
        backtrack(1, n, k);
        return res;
    }

    // 回溯算法核心函数，遍历子集问题的回溯树
    private void backtrack(int start, int n, int k) {
        // 前序位置，每个节点的值都是一个子集
        // 遍历到了第 k 层，收集当前节点的值
        if (track.size() == k){
            res.add(new ArrayList<>(track));
            return;
        }

        // 回溯算法标准框架，for 选择 in 选择列表
        // 选择列表是 [start,n]  用 i 做选择
        for (int i = start; i <= n; i++) {
            // 做选择，将选择加入路径
            track.add(i);
            // 通过 start 参数控制树枝的便利，避免产生重复的子集
            backtrack(i+1, n, k);
            // 撤销选择，将选择从路径中移除
            track.removeLast();

        }
    }

    // 简单修改 子集方法也可
//    List<List<Integer>> res = new LinkedList<>();
//
//    // 记录回溯算法的递归路径
//    LinkedList<Integer> track = new LinkedList<>();
//
//    // 主函数
//    public List<List<Integer>> combine(int n, int k){
//        int [] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = i+1;
//        }
//        backtrack(nums, 0,k);
//        return res;
//    }
//
//    // 回溯算法核心函数，遍历子集问题的回溯树
//    private void backtrack(int[] nums, int start, int k) {
//        // 前序位置，每个节点的值都是一个子集
//        // 只返回 size 为 2 的结点
//        if (track.size() == k){
//            res.add(new ArrayList<>(track));
//        }
//
//        // 回溯算法标准框架，for 选择 in 选择列表
//        for (int i = start; i < nums.length; i++) {
//            // 做选择
//            track.add(nums[i]);
//            // 通过 start 参数控制树枝的便利，避免产生重复的子集
//            backtrack(nums, i+1, k);
//            // 撤销选择
//            track.removeLast();
//
//        }
//
//    }
}

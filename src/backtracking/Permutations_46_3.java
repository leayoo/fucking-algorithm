package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: Leeyoa
 * @description:
 * @date: 2023/7/14 9:44
 */
/*
    全排列问题
    组合/子集问题使用 start 保证变量元素 nums[start] 之后
    只会出现 nums[start+1..] 中的元素，通过固定元素的相对位置保证不出现重复子集

    但排列问题本身就是让你穷举元素的位置，
    nums[i] 之后也可以出现 nums[i] 左边的元素，
    所以需要额外使用 used 数组来标记哪些元素还可以被选择。
 */
public class Permutations_46_3 {
    List<List<Integer>> res = new LinkedList<>();
    // 记录回溯算法的递归路径
    LinkedList<Integer> track = new LinkedList<>();
    // track 中的元素会被标记为 true
    boolean[] used;

    // 主函数
    public List<List<Integer>> permute(int[] nums){
        // 知道 nums 的长度后，对 used 进行初始化
        used = new boolean[nums.length];
        backtrack(nums);
        return res;
    }

    // 回溯算法核心函数，遍历子集问题的回溯树
    private void backtrack(int[] nums) {
        // 前序位置，每个节点的值都是一个子集
        // base case 到达叶子节点
        if (track.size() == nums.length){
            res.add(new ArrayList<>(track));
        }

        // 回溯算法标准框架，for 选择 in 选择列表
        for (int i = 0; i < nums.length; i++) {
            if (used[i]){
                continue;
            }
            // 做选择
            track.add(nums[i]);
            used[i] = true;
            // 通过 start 参数控制树枝的便利，避免产生重复的子集
            backtrack(nums);
            // 撤销选择
            track.removeLast();
            used[i] = false;
        }
    }
}

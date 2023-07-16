package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: Leeyoa
 * @description:
 * @date: 2023/7/14 9:06
 */

// 子集问题，元素无重不可复选
public class Subsets_78 {
    List<List<Integer>> res = new LinkedList<>();

    // 记录回溯算法的递归路径
    LinkedList<Integer> track = new LinkedList<>();

    // 主函数
    public List<List<Integer>> subsets(int[] nums){
        backtrack(nums, 0);
        return res;
    }

    // 回溯算法核心函数，遍历子集问题的回溯树
    private void backtrack(int[] nums, int start) {
        // 前序位置，每个节点的值都是一个子集
        res.add(new ArrayList<>(track));

        // 回溯算法标准框架，for 选择 in 选择列表
        for (int i = start; i < nums.length; i++) {
            // 做选择
            track.add(nums[i]);
            // 通过 start 参数控制树枝的便利，避免产生重复的子集
            backtrack(nums, i+1);
            // 撤销选择
            track.removeLast();

        }

    }


}

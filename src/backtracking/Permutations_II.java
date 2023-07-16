package backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: Leeyoa
 * @description:
 * @date: 2023/7/14 10:02
 */
public class Permutations_II {
    List<List<Integer>> res = new LinkedList<>();

    LinkedList<Integer> track = new LinkedList<>();

    boolean[] used;

    List<List<Integer>> permuteUnique(int[] nums){
        // 先排序，让相同的元素靠在一起
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backtrack(nums);
        return res;
    }

    private void backtrack(int[] nums) {
        if (track.size() == nums.length){
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]){
                continue;
            }
            // 新添加的剪枝逻辑，固定相同的元素在排列中的相对位置
            if (i>0 && nums[i] == nums[i-1] && !used[i-1]){
                continue;
            }
            // 做选择
            track.add(nums[i]);
            used[i] = true;

            backtrack(nums);

            // 撤销选择
            track.removeLast();
            used[i] = false;

        }
    }

}

package backtracking;

import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Permutations_46 {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        // 「路径」中的元素被标记为 true，避免重复使用
        boolean[] used = new boolean[nums.length];

        backtrack(nums, track, used);
        return res;
    }
    // 路径: 记录在 track 中
    // 选择列表: nums 中不在于 track 的那些元素 (used[i] 为 false
    // 结束条件: nums 中的元素全部都在 track 中出现
    void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used){
        // 触发结束条件
        if (track.size() == nums.length){
            res.add(new LinkedList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++){
            // 排除不合法的选择
            if (used[i]){
                // nums[i] 已经在 track 中，跳过
                continue;
            }
            // 做选择
            track.add(nums[i]);
            used[i] = true;
            // 进入下一层选择树
            backtrack(nums, track, used);
            // 取消选择
            track.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Permutations_46 permutations = new Permutations_46();
        List<List<Integer>> permute = permutations.permute(nums);
        System.out.println(permute);
    }
}


//leetcode submit region end(Prohibit modification and deletion)


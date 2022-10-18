package nsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSum_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        /*
        这样，我们再泛化一下题目，计算和为 target 的三元组吧，
        同上面的 twoSum 一样，也不允许重复的结果
         */
        // 求和为 0 的三元组
        return threeSumTarget(nums, 0);
    }

    // 输入数组 nums，返回所有和为 target 的三元组
    private List<List<Integer>> threeSumTarget(int[] nums, int target) {
        // 数组先排个序
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        // 穷举 threeSum 的第一个数
        for (int i = 0; i < n; i++) {
            // 对 target - nums[i] 计算 twoSum
            List<List<Integer>> tuples = twoSumTarget(nums, i + 1, target - nums[i]);
            // 如果存在满足条件的二元组，再加上 nums[i] 就是结果三元组
            for (List<Integer> tuple : tuples) {
                tuple.add(nums[i]);
                res.add(tuple);
            }
            // 跳过第一个数字重复的情况，否则会出现重复结果
            while (i < n - 1 && nums[i] == nums[i + 1]) i++;
        }
        return res;
    }

    /* 从 nums[start] 开始，计算有序数组
     * nums 中所有和为 target 的二元组 */
    List<List<Integer>> twoSumTarget(int[] nums, int start, int target) {
        // 左指针改为从 start 开始，其他不变
        int lo = start, hi = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();

        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            // 记录索引 lo 和 hi 最初对应的值
            int left = nums[lo], right = nums[hi];
            if (sum < target) {
                while (lo < hi && nums[lo] == left) lo++;
            } else if (sum > target) {
                while (lo < hi && nums[hi] == right) hi--;
            } else {
                res.add(new ArrayList<Integer>(Arrays.asList(left, right)));
                while (lo < hi && nums[lo] == left) lo++;
                while (lo < hi && nums[hi] == right) hi--;
            }
        }
        return res;
    }
}

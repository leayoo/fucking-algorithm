package nsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSum {
    /*
    如果假设输入一个数组 nums 和一个目标和 target，
    请你返回 nums 中能够凑出 target 的两个元素的值，
    比如输入 nums = [5,3,1,6], target = 9，那么算法返回两个元素 [3,6]。
    可以假设只有且仅有一对儿元素可以凑出 target。
     */
    public int[] twoSum(int[] numbers, int target) {
        // 先对数组排序
        Arrays.sort(numbers);
        // 一左一右两个指针相向而行
        int lo = 0, hi = numbers.length - 1;
        while (lo < hi) {
            int sum = numbers[lo] + numbers[hi];
            if (sum == target) {
                return new int[]{lo, hi};
            } else if (sum < target) {
                lo++;
            } else if (sum > target) {
                hi--;
            }
        }
        return new int[]{-1, -1};
    }

    /*
    魔改题目，把这个题目变得更泛化，更困难一点：
    nums 中可能有多对儿元素之和都等于 target，
    请你的算法返回所有和为 target 的元素对儿，其中不能出现重复。
     */
    List<List<Integer>> twoSumTarget(int[] nums, int target) {
        // 先对数组排序
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            // 记录索引 lo 和 hi 最初对应的值
            int left = nums[lo], right = nums[hi];
            if (sum < target) {
                lo++;
            } else if (sum > target) {
                hi--;
            } else {
                res.add(new ArrayList<Integer>(Arrays.asList(left, right)));
                while (lo < hi && nums[lo] == left) lo++;
                while (lo < hi && nums[hi] == right) hi--;
            }
        }
        return res;
    }

    /*
    优化
     */
    List<List<Integer>> twoSumTarget2(int[] nums, int target) {
        // 先对数组排序
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int lo = 0, hi = nums.length - 1;
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

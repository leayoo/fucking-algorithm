package binarysearch;
// 用滑动窗口做也不错
// 这里用二分搜索做
public class FindFirstAndLastPositionOfElementInSortedArray_34 {
    public int[] searchRange(int[] nums, int target) {
        int left = left_bound2(nums, target);
        int right = right_bound2(nums, target);
        return new int[]{left, right};
    }

    // 寻找左侧边界的二分搜素,左闭右闭
    int left_bound2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // 搜索区间为 [left, right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // 搜索区间变为 [mid+1, right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索区间变为 [left, mid-1]
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 收缩右边界，搜索区间变为 [mid+1, right]
                right = mid - 1;
            }
        }
        // 判断 target 是否存在于 nums 中
        // 此时 target 比所有数都大， 返回 -1
        if (left == nums.length) return -1;
        // 判断一下 nums[left] 是不是 target
        return nums[left] == target ? left : -1;
    }

    // 寻找右侧边界的二分查找，左闭右闭
    int right_bound2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                left = mid + 1;
            }
        }
        if (left - 1 < 0) return -1;
        return nums[left - 1] == target ? (left - 1) : -1;
    }
}

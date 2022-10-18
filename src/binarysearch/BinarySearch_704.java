package binarysearch;

public class BinarySearch_704 {
    // 寻找一个数
    public int search(int[] nums, int target) {
        // 搜索区间 [left, right]
        int left = 0;
        int right = nums.length - 1; // 注意

        // 终止条件为 left == right + 1, 写成区间就是 [right+1, right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1; // 注意
            else if (nums[mid] > target)
                right = mid - 1; // 注意
        }
        return -1;
    }

    // 寻找左侧边界的二分搜素,左闭右开
    int left_bound1(int[] nums, int target) {
        // 搜索区间 [left, right)
        int left = 0;
        int right = nums.length; // 注意

        // 终止条件为 left == right，此时搜索区间为 [left, left)
        while (left < right) { //注意
            int mid = left + (right - left) / 2;
            /*
            因为我们的「搜索区间」是 [left, right) 左闭右开，
            所以当 nums[mid] 被检测之后，下一步应该去 mid 的左侧或者右侧区间搜索，
            即 [left, mid) 或 [mid + 1, right)。
             */
            if (nums[mid] == target) {
                // 收缩右边界
                // 搜索区间变为 [left, mid)
                right = mid;
            } else if (nums[mid] < target) {
                // 搜索区间变为 [mid+1, right)
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索区间变为 [left, mid)
                right = mid; // 注意
            }
        }
        /*
        假如输入的 target 非常大，那么就会一直触发 nums[mid] < target 的 if 条件，
        left 会一直向右侧移动，直到等于 right，while 循环结束。
        由于这里 right 初始化为 nums.length，所以 left 变量的取值区间是闭区间 [0, nums.length]，
        那么我们在检查 nums[left] 之前需要额外判断一下，防止索引越界：
         */
        if (left == nums.length) return -1;
        return nums[left] == target ? left : -1;
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

    // 寻找右侧边界的二分查找，左闭右开
    // 动闭的一边时，取 mid 旁边的值
    // 动开的一边时，取 mid
    int right_bound1(int[] nums, int target) {
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        // 判断 target 是否存在于 nums 中
        // 此时 left - 1 索引越界
        if (left - 1 < 0) return -1;
        // 判断一下 nums[left] 是不是 target
        return nums[left - 1] == target ? (left - 1) : -1;
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

class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {  // Make sure to include equality in the loop condition
            int mid = left + (right - left) / 2;  // Avoid potential overflow

            if (nums[mid] == target) {
                return mid;
            }

            // Check if the left side is sorted
            if (nums[left] <= nums[mid]) {
                // If target is within the left sorted half
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;  // Move to the left half
                } else {
                    left = mid + 1;  // Move to the right half
                }
            } 
            // Right side is sorted
            else {
                // If target is within the right sorted half
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;  // Move to the right half
                } else {
                    right = mid - 1;  // Move to the left half
                }
            }
        }

        return -1;  // Target not found
    }
}
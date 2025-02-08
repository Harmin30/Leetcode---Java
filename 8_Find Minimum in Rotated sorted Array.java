class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            if (nums[left] < nums[right]) {
                return nums[left]; // The segment is already sorted
            }

            int mid = left + (right - left) / 2; // Avoid overflow

            if (nums[mid] >= nums[left]) {
                left = mid + 1; // Minimum is on the right side
            } else {
                right = mid; // Minimum is on the left side or at mid
            }
        }
        return nums[left]; // The minimum element
    }
}
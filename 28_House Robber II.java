class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0]; // Edge case: Only one house

        // Case 1: Rob from index 0 to n-2 (excluding last house)
        int case1 = robHelper(nums, 0, nums.length - 2);
        
        // Case 2: Rob from index 1 to n-1 (excluding first house)
        int case2 = robHelper(nums, 1, nums.length - 1);
        
        return Math.max(case1, case2);
    }

    private int robHelper(int[] nums, int start, int end) {
        int rob1 = 0, rob2 = 0;
        
        for (int i = start; i <= end; i++) {
            int newRob = Math.max(rob1 + nums[i], rob2);
            rob1 = rob2;
            rob2 = newRob;
        }
        
        return rob2;
    }
}

class Solution {
    public int punishmentNumber(int n) {
        int punishmentSum = 0;
        
        for (int i = 1; i <= n; i++) {
            int square = i * i;
            String squareStr = String.valueOf(square);
            
            if (isValid(squareStr, i, 0, 0)) {
                punishmentSum += square;
            }
        }
        
        return punishmentSum;
    }
    
    private boolean isValid(String num, int target, int index, int currentSum) {
        if (index == num.length()) {
            return currentSum == target;
        }
        
        for (int i = index; i < num.length(); i++) {
            int part = Integer.parseInt(num.substring(index, i + 1));
            if (currentSum + part > target) break;
            
            if (isValid(num, target, i + 1, currentSum + part)) {
                return true;
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.punishmentNumber(10));  // Output: 182
    }
}

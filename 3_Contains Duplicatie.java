class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Create a HashSet to store elememts from the array 
        HashSet<Integer> seenNumbers = new HashSet<>();

        // Iterate through each element in the array
        for (int num : nums ) {
            // Check if the element is already in the HashSet
            if(seenNumbers.contains(num)) {
                return true; //Dunplicate found 
            }
            // Add The element to the HashSet
            seenNumbers.add(num);
        } 
        return false; //No duplicate foung
        }    
}
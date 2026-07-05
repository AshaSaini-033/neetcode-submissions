class Solution {
    public boolean hasDuplicate(int[] nums) {
        // if sorted and sequence 
        int n = nums.length;
        Arrays.sort(nums);
        int i=0;
        while(i<n-1){
            if(nums[i]==nums[i+1]) return true;
           i++;
        }
        return false;
    }
}
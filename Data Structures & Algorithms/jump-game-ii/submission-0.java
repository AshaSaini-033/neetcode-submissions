class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int currIdx = 0;
        int jumps = 0;
        int maxReach = 0;

        for(int i=0;i<n-1;i++){
         maxReach  = Math.max(maxReach, i+nums[i]);
         if(currIdx==i){jumps++;
         currIdx = maxReach;}
        }
        return jumps;
    }
}

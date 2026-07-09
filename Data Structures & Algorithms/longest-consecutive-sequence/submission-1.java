class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if(n==0 || n==1) return n;
        int max = 0;
        int cnt =0;
        for(int i =0;i<n-1;i++){
         if((nums[i]+1)==nums[i+1]) cnt++;
         else if(nums[i]==nums[i+1]) continue;
         else cnt =0;
           max = Math.max(max,cnt);
        }

        return max+1;

    }
}

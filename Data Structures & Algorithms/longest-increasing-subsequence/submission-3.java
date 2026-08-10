class Solution {
    int n;
    public int lengthOfLIS(int[] nums) {
        n = nums.length;
     
        int dp[][] = new int[n][n+1];
     for(int i=0;i<n;i++){
        Arrays.fill(dp[i],-1);
     }
        return func(0,nums,-1,dp);

    }
    public int func(int i,int nums[],int prevIdx,int dp[][]){
        if(i>=n) return 0;
        if(dp[i][prevIdx+1]!=-1) return dp[i][prevIdx+1];
        int take=0;
        if(prevIdx==-1||nums[i]>nums[prevIdx]){
           take = 1+func(i+1,nums,i,dp);
        }
        int nottake = func(i+1,nums,prevIdx,dp);
        return dp[i][prevIdx+1] =Math.max(take,nottake);

    }
}

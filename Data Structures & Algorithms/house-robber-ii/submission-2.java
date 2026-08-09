class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
      int dp[] = new int[n];
      Arrays.fill(dp,-1);
      int x1 = func(0,n-2,nums,dp);
      Arrays.fill(dp,-1);
      int x2 = func(1,n-1,nums,dp);
      return Math.max(x1,x2);
    }
    public int func(int i,int n,int nums[],int dp[]){
        if(i>n) return 0;
        if(dp[i]!=-1) return dp[i];
        int take = nums[i]+func(i+2,n,nums,dp);
        int nottake = func(i+1,n,nums,dp);
        return dp[i]=Math.max(take,nottake);
    }
}

class Solution {
    int n,sum;
    public int findTargetSumWays(int[] nums, int target) {
        n = nums.length;
    for(int i=0;i<n;i++){
        sum +=nums[i];
    }
      int dp[][] = new int[n+1][2*sum+1];
      for(int i=0;i<n+1;i++){
        Arrays.fill(dp[i],-1);
      }
        return func(0,nums,target,dp);
    }
    public int func(int idx,int nums[],int target,int dp[][]){
        if(idx==n && target==0) return 1;
      if(target < -sum || target > sum||idx>=n)
    return 0;
       if(dp[idx][target+sum]!=-1) return dp[idx][target+sum];
        //sunb
        int sub = func(idx+1,nums,target-nums[idx],dp);
        //add
        int add = func(idx+1,nums,target+nums[idx],dp);
        return dp[idx][target+sum] =  sub+add; 
    }
}


class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return Math.min(func(cost,n-1,dp),func(cost,n-2,dp));
        
    }
    public int func(int cost[],int i,int dp[]){
        if(i==0||i==1) return cost[i];
      
        if(dp[i]!=-1) return dp[i];
      dp[i] =cost[i]+Math.min(func(cost,i-1,dp),func(cost,i-2,dp));
     return dp[i];
    }
}

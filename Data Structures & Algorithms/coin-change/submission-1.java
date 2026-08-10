class Solution {
    int n ;
 
    public int coinChange(int[] coins, int amount) {
        n = coins.length;
       
        int dp[][] = new int[n][amount+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
         int ans = func(coins,0,amount,dp);
        return ans==Integer.MAX_VALUE?-1:ans;

    }
    public int func(int coins[],int idx,int amount,int dp[][]){
         if(idx>=n || amount<0) return Integer.MAX_VALUE;
        if(amount==0) return 0;
        if(dp[idx][amount]!=-1) return dp[idx][amount];
         int take =  func(coins,idx,amount-coins[idx],dp);
         if(take!=Integer.MAX_VALUE) take = take +1;
         int nottake = func(coins,idx+1,amount,dp);
         return dp[idx][amount]= Math.min(take,nottake);


        
    }
}

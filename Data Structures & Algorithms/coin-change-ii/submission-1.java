class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][]= new int[n][amount+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return func(0,amount,coins,dp);
    }
    public int func(int idx,int amount,int coins[],int dp[][]){
        if(idx>=coins.length || amount<0) return 0;

        if(amount == 0 ) return 1;
         if(dp[idx][amount] !=-1) return dp[idx][amount];
        //pick 
        int pick = func(idx,amount-coins[idx],coins,dp);
        //not pick
        int notpick = func(idx+1,amount,coins,dp);
        return dp[idx][amount] =  pick+notpick;
    }
}

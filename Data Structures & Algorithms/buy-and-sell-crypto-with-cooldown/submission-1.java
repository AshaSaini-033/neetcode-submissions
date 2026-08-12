class Solution {
    public int maxProfit(int[] prices) {
        Integer dp[][] = new Integer[prices.length][2];
        return func(prices,0,true,dp);

    }
    public int func(int nums[],int idx,boolean canbuy,Integer dp[][]){
        if(idx>=nums.length) return 0;
  int state = canbuy?1:0;
  if(dp[idx][state] !=null) return dp[idx][state];
        int x=0;
        int y=0;

        if(canbuy){
            x = Math.max(func(nums,idx+1,true,dp),func(nums,idx+1,false,dp)-nums[idx]);
        }else 
        {
             y = Math.max(func(nums,idx+1,false,dp),func(nums,idx+2,true,dp)+nums[idx]);
        }
      return  dp[idx][state]=Math.max(x,y);
    }
}

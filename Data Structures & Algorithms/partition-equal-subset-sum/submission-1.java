class Solution {
     int sum;
     int n;
    public boolean canPartition(int[] nums) {
      n= nums.length;
   
    
        for(int i=0;i<n;i++){
            sum+= nums[i];
        }
          if(sum%2==1) return false;
             Boolean dp[][] = new Boolean[n][(sum/2)+1];
      
     

            return func(nums,sum/2,0,dp);
    
    }
    public boolean func(int nums[],int target,int i,Boolean dp[][]){
        if(i>=n || target<0) return false;
        if(target ==0) return true;
        if(dp[i][target] !=null) return dp[i][target];
     return dp[i][target] =  func(nums,target-nums[i],i+1,dp)|| func(nums,target,i+1,dp);
    }
}

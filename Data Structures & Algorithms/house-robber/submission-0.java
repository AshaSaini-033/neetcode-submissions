class Solution {
    int n;
    public int rob(int[] nums) {
        n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return  func(nums,0,dp);

    }
    public int func(int nums[],int i,int dp[]){
if(i>=n) return 0;
if(dp[i]!=-1) return dp[i];
int take =nums[i]+ func(nums,i+2,dp);
int nottake = func(nums,i+1,dp);
 return dp[i]=Math.max(take,nottake);

    }
}

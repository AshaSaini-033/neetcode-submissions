class Solution {
     int sum;
     int n;
    public boolean canPartition(int[] nums) {
      n= nums.length;
        for(int i=0;i<n;i++){
            sum+= nums[i];
        }

        if(sum%2==1) return false;
        else{
            return func(nums,sum/2,0);
        }
    }
    public boolean func(int nums[],int target,int i){
        if(i>=n || target<0) return false;
        if(target ==0) return true;
        return func(nums,target-nums[i],i+1)|| func(nums,target,i+1);
    }
}

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int pre[] = new int[n];
        int suff[] = new int[n];
        int mul = 1;
        pre[0] = suff[n-1] = 1;
        for(int i=1;i<n;i++){
        mul = mul*nums[i-1];  
        pre[i] = mul;
        }
        mul =1;
        for(int i=n-2;i>=0;i--){
        mul = mul*nums[i+1];  
        suff[i] = mul;
        }
        int ans[] = new int[n];
        for(int i=0;i<n;i++){
         ans[i] = pre[i]*suff[i];
        }
        return ans;
    }
}  

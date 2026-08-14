class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
    //  Arrays.sort(nums);
    //     for(int i=0;i<n;i++){
    //       if(i!=nums[i]) return i;
    //     }
    int xor1 =0;
    int xor2=0;
    for(int i=0;i<n+1;i++){
        xor1 = xor1^(i<n?nums[i]:0);
        xor2 = xor2^i;
    }
    return xor1^xor2;
    
    }
}

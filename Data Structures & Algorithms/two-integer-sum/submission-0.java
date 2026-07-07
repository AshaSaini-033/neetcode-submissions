class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i=0;
        int n = nums.length;
        int ans[] = new int[2];
        HashMap<Integer,Integer> hm = new HashMap<>();
        while(i<n){
            int diff = target-nums[i];
            if(hm.containsKey(diff)){
                ans[0] = hm.get(diff);
                ans[1] = i;
            }else{
                hm.put(nums[i],i);
            }
            i++;
        }
        return ans;
    }
}

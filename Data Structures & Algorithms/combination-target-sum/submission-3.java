class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        func(0,nums,target,list);
        return ans;
    }
    public void func(int idx,int nums[],int target,List<Integer> list){
        if(target==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(idx==nums.length || nums[idx]>target){
            return;
        }
        list.add(nums[idx]);
        func(idx,nums,target-nums[idx],list);
        list.remove(list.size()-1);
        func(idx+1,nums,target,list);
    }
}

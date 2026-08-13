class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        func(0,candidates,target,list);
        return ans;
    }
    public void func(int idx,int nums[],int target,List<Integer> list){
   if(target==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(idx==nums.length|| nums[idx]>target){
            return;
        }
      
        //take
        for(int i=idx;i<nums.length;i++){
        if(i>idx && nums[i]==nums[i-1]) continue;
        list.add(nums[i]);
        func(i+1,nums,target-nums[i],list);
        list.remove(list.size()-1);
        //not take
      
        }
    }
}

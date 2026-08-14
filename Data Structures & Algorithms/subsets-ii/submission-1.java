class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        func(0,nums,list);
        return ans;
    }
    public void func(int idx,int nums[],List<Integer> list){
     
            ans.add(new ArrayList<>(list));
      
        for(int i=idx;i<nums.length;i++){
            if(i > idx && nums[i] == nums[i-1])
    continue;
            list.add(nums[i]);
            func(i+1,nums,list);
            list.remove(list.size()-1);

        }
    }
}

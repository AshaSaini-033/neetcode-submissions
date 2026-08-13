class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list =new ArrayList<>();
        func(0,nums,list);
        return ans;
    }
    public void func(int idx,int nums[],List<Integer> list){
        if(idx==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[idx]);
        func(idx+1,nums,list);
        list.remove(list.size()-1);
        func(idx+1,nums,list);
    }

}

class Solution {

    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {

        List<Integer> list = new ArrayList<>();

        func(0,nums,list);
        return ans;
        
    }
    public void func(int idx,int nums[],List<Integer> list){
       if(list.size()==nums.length){
        ans.add(new ArrayList<>(list));
        return;
       }
       if(idx==nums.length) return ;

       for(int i=0;i<nums.length;i++){

        if(list.contains(nums[i]))continue;
          list.add(nums[i]);
        func(i,nums,list);
        list.remove(list.size()-1);

       }
    }
}

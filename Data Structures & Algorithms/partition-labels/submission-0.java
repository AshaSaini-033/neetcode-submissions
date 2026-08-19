class Solution {
    public List<Integer> partitionLabels(String s) {
        int lastIndex[] = new int[26];
        int n = s.length();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
             lastIndex[ch-'a'] = i;
        }
        int len =0;
        int start =0;
        int end = 0;
        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<n;i++){
              char ch = s.charAt(i);
             end  = Math.max(end,lastIndex[ch-'a']);
             if(end==i){
                len = end-start+1;
                ans.add(len);
                 start = i+1;
             }
            
        }
        return ans;
    }
}

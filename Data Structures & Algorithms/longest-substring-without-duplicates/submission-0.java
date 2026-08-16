class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0;
        int j=0;
        int len = 0;
        HashMap<Character,Integer> hm = new HashMap<>();
        int n = s.length();
        if(n==0) return len;
        while(j<n){
            char ch = s.charAt(j);
       
            if(!hm.containsKey(ch)){
                hm.put(ch,1);
                len = Math.max(len,hm.size());
                j++;
            }else{
                char ch2 = s.charAt(i);

                hm.remove(ch2);
                i++;
            }

        }
        return len;
    }
}

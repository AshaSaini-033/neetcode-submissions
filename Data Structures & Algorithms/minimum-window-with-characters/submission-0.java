class Solution {
    public String minWindow(String s, String t) {
        
        HashMap<Character,Integer> hm= new HashMap<>();
        int tlen = t.length();
        int slen = s.length();
        for(int i=0;i<tlen;i++){
            char ch = t.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        int left = 0;
        int right = 0;
        int cnt=0;
        int sidx = -1;
        int min = Integer.MAX_VALUE;
        while(right <slen){
        char ch = s.charAt(right);
        if(hm.containsKey(ch)){
        
            if(hm.get(ch)>0){
            cnt++;
            }
            hm.put(ch,hm.get(ch)-1);

            while(cnt==tlen){
                char ch2 = s.charAt(left);
                 if(min>(right-left+1)){min = right-left+1;
                 sidx = left;}
                if( hm.containsKey(ch2)){                hm.put(ch2,hm.get(ch2)+1);
                 if(hm.get(ch2)>0)cnt--;
               
                 }
                 left++;
            }

        }
 right++;
        }
        
        return sidx==-1?"":s.substring(sidx,min+sidx);
    }
    
}

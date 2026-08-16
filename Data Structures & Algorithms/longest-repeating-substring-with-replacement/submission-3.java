class Solution {
    public int characterReplacement(String s, int k) {
        int i=0;
        int j =0;
        int n = s.length();
        int freq[] = new int[26];
        int ans =0;
        int maxfreq =0;
          int winlen =0;
        while(j<n){ 
            char ch = s.charAt(j);
             
            freq[ch-'A']++;
            maxfreq = Math.max(maxfreq,freq[ch-'A']);
            int diff = winlen-maxfreq;
            while(((j-i+1)-maxfreq)>k){
             freq[s.charAt(i)-'A']--;
                  i++;
            }
            
               
               ans = Math.max(ans,j-i+1);  
               j++;
            
          
        }
        return ans;
        
    }
}

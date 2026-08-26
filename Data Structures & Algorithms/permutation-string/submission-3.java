class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int lens1 = s1.length();
        int lens2 = s2.length();
if (lens1 > lens2) return false;
        int freq[] = new int[26];
        for(int i=0;i<lens1;i++){
            char ch = s1.charAt(i);
            freq[ch-'a']++;
        }
        int i=0;
        int j = lens1;
        int win[] = new int[26];
        for(int k=0;k<j;k++){
          char ch = s2.charAt(k);
          win[ch-'a']++;
        }
        while(j<lens2){
           if(Arrays.equals(win,freq)) return true;
           win[s2.charAt(i)-'a']--;
           i++;
           win[s2.charAt(j)-'a']++;
           j++;

        }
        return Arrays.equals(win, freq);
    }
}

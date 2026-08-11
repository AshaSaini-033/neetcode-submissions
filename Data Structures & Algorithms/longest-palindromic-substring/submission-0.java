class Solution {
     int n;
   
    Boolean dp[][];
    public String longestPalindrome(String s) {
        n = s.length();
         int cnt=0;
         int max = 0;
         StringBuilder ans = new StringBuilder("");
        dp=new Boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(isPalindrome(s,i,j,dp)){
                    if(max<(j+1-i)){
                        max = j+1-i;
                        ans = new StringBuilder(s.substring(i, j + 1));
                       }
                }
            }
        }
        return ans.toString();
    }
    public boolean isPalindrome(String s,int i,int j,Boolean dp[][])
    {
    
      if(i>=j) return true;
      if(dp[i][j]!=null) return dp[i][j];
       if(s.charAt(i)!=s.charAt(j)) return false;
       return dp[i][j] = isPalindrome(s,i+1,j-1,dp);
    }
}

class Solution {
    int n;
   
    Boolean dp[][];
    public int countSubstrings(String s) {
        n = s.length();
         int cnt=0;
        dp=new Boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(isPalindrome(s,i,j,dp))cnt++;
            }
        }
        return cnt;
    }
    public boolean isPalindrome(String s,int i,int j,Boolean dp[][])
    {
    
      if(i>=j) return true;
      if(dp[i][j]!=null) return dp[i][j];
       if(s.charAt(i)!=s.charAt(j)) return false;
       return dp[i][j] = isPalindrome(s,i+1,j-1,dp);
    }
}

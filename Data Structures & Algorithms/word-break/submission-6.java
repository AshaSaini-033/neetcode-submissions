class Solution {
      int n ;
    public boolean wordBreak(String s, List<String> wordDict) {
      n= s.length();
        Boolean dp[][] = new Boolean[n][n+1];
      return  func(s,wordDict,0,0,dp);
    }
    public boolean func(String str,List<String> word,int i,int j,Boolean dp[][]){
      if (i >= n) return true;
if (j == n) return false;
       // else if(word.contains(str.substring(i,j+1)))  return true;
       if(dp[i][j] !=null) return dp[i][j];
        boolean b1=false;
        if(word.contains(str.substring(i,j+1))){
          b1 = func(str,word,j+1,j+1,dp);
        }
        boolean b2 = func(str,word,i,j+1,dp);
        return dp[i][j] = b1||b2;
    }
}

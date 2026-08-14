class Solution {
    public int[] countBits(int n) {
        int ans[] = new int[n+1];
        for(int i=0;i<n+1;i++){
       ans[i] = func(i,0);
        }
        return ans;
    }
    public int func(int n,int cnt){
        while(n!=0){
            n = n&(n-1);
        cnt++;
        }
        return cnt;
    }
}

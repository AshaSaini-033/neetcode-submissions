class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int right = 0;
        int left =1;
        int  n = piles.length;
        for(int i=0;i<n;i++){
            right = Math.max(right,piles[i]);
        }
        while(left<right){
        int mid = left+(right-left)/2;
        int hour =0;
         for(int i=0;i<n;i++){
        hour +=  (piles[i]+mid-1)/mid;

         }
         if(hour>h){
            left = mid+1;
         }else{
            right  = mid;
         }
        }
        return left;
    }
}

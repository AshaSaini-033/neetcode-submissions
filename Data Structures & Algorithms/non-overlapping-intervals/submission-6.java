class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int prev = intervals[0][1];
        int cnt =0;
        for(int i=1;i<n;i++){
            if(intervals[i][0]<prev){
                cnt++;
                 prev = Math.min(intervals[i][1],prev);
            }
            else{
             prev = intervals[i][1];
            }
             

        }
        return cnt;
    }
}

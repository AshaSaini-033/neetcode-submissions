class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
         List<int[]> ans =   new ArrayList<>();
         //not found overlapping 
         int i=0;
        while(i<n && intervals[i][1]<newInterval[0]){ 
            ans.add(intervals[i]);
            i++;
        }
        while(i<n && intervals[i][0]<=newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1],newInterval[1]);
            i++;
        }
        ans.add(newInterval);
        while(i<n){
            ans.add(intervals[i]);
            i++;
        }
        int s = ans.size();
        int arr[][] = new int[s][2];
        for(int j=0;j<s;j++){
            arr[j] = ans.get(j);
        }
        return arr;
    }
}

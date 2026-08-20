class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        int i=1;
        List<int[]> ans = new ArrayList<>();
        ans.add(intervals[0]);
        while(i<n){
            if((intervals[i][0]==ans.get(ans.size()-1)[0])||(intervals[i][0]<=ans.get(ans.size()-1)[1])){
          ans.get(ans.size()-1)[0] = Math.min(intervals[i][0],ans.get(ans.size()-1)[0]);
          ans.get(ans.size()-1)[1] = Math.max(intervals[i][1],ans.get(ans.size()-1)[1]);
            }else{
                ans.add(intervals[i]);
            }
          i++;
        }
      
        int arr[][] = new int[ans.size()][2];
        for(int j=0;j<ans.size();j++){
arr[j] = ans.get(j);
        }
        return arr;
    }
}

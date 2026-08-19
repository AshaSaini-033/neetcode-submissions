class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int n = triplets.length;
        int m = triplets[0].length;

        int k = target.length;

        boolean f1 = false;
        boolean f2 = false;
        boolean f3 = false;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(triplets[i][0] > target[0] ||
   triplets[i][1] > target[1] ||
   triplets[i][2] > target[2]) {
    continue;
}
if(triplets[i][0] == target[0]) f1 = true;
if(triplets[i][1] == target[1]) f2 = true;
if(triplets[i][2] == target[2]) f3 = true;



            }
        }
        return f1 && f2 && f3;
    }
}

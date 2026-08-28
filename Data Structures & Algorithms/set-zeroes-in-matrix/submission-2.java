class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        boolean cols[] = new boolean[n];
        boolean rows[] = new boolean[m];

        for(int i=0;i<m;i++){
            for(int j =0;j<n;j++){
                if(matrix[i][j]==0){
                    cols[j] = true;
                    rows[i] = true;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j =0;j<n;j++){
                if( cols[j] == true||rows[i] == true){
                    matrix[i][j] =0;

                   
                }
            }
        }

        
    }
}

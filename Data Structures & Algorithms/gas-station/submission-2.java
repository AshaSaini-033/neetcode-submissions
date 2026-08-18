class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int tg = 0;
        int tc = 0;
        int start = 0;
        int tank = 0;
        for(int i=0;i<n;i++){
           tg +=gas[i];
           tc +=cost[i];
        }
        if(tg<tc) return -1;
        else{
            //possible 
            for(int i=0;i<n;i++){
                tank += gas[i]-cost[i];
                       if(tank<0){
                        start=i+1;
                        tank =0;
                       }
            }

        }
        return start;
    }
}

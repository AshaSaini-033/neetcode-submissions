class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(n!=1){

            int sum =0;
            while(n!=0){
           
           int r = n%10;
           sum +=r*r;
           n = n/10;
            }
            if(sum!=1 && set.contains(sum)) return false;
            else{
                set.add(sum);

            }
            n = sum;


        }
        return true;
    }
}

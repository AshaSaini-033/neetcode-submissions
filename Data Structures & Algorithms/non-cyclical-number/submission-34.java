class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do{
            slow = sumofsq(slow);
            fast = sumofsq(sumofsq(fast));

        }while(slow!=fast);
        return slow ==1;

    }
    public int sumofsq(int n){
        int sum =0;
        while(n>0){
           int r = n%10;
           sum +=r*r;
           n = n/10;
        }
        return sum;
    }
}

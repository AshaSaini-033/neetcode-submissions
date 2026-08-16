class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int n = prices.length;
        int max = 0;
        for(int j=0;j<n;j++){
           min = Math.min(prices[j],min);
           int  profit = prices[j]-min;
           max = Math.max(max,profit);
        }
        return max;
    }
}

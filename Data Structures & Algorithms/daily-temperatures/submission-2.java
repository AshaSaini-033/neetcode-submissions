class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        Stack<int[]> st = new Stack<>();
        int res[] = new int[n];
        for(int i=n-1;i>=0;i--){
        //   if(st.isEmpty()){res[i] = 0;
        //   }
          while(!st.isEmpty() && st.peek()[0]<=temp[i]){
            st.pop();
          }
          if(!st.isEmpty() && st.peek()[0]>temp[i]){res[i] = st.peek()[1]-i;}

          st.push(new int[]{temp[i],i});

        }
        return res;
    }
}

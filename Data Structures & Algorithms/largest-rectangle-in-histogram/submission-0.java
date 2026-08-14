class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
 int max = 0;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            if(!st.isEmpty()){
                while(!st.isEmpty()&&heights[st.peek()]>=heights[i]){
                        int h = heights[st.pop()];
                        int left = st.isEmpty()?-1:st.peek();
                        int right = i;
                        int area = h*(right-left-1);
           max = Math.max(max,area);
                }
            }
                st.push(i);
            }
            while(!st.isEmpty()){
                int h = heights[st.pop()];
                int left = !st.isEmpty()?st.peek():-1;
                int right = n;
                int area = h*(right-left-1);
                max = Math.max(area,max);
            }
            return max;
        }

        
    }


class MinStack {
    Stack<Integer> st = new Stack<>();

    Stack<Integer> minst = new Stack<>();


    public MinStack() {
        
    }
    
    public void push(int val) {
        st.push(val);
        if(minst.isEmpty() || minst.peek()>=val){
            minst.push(val);
        }
        
    }
    
    public void pop() {
     if(!st.isEmpty()){int removed = st.pop();

if (!minst.isEmpty() &&removed == minst.peek()) {
    minst.pop();
}
     }
    }
    
    public int top() {
        if(!st.isEmpty()) return st.peek();
        else return 0;
    }
    
    public int getMin() {
        if(!minst.isEmpty()) return minst.peek();
        return 0;
    }
}

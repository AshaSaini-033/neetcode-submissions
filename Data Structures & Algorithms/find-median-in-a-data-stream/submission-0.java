class MedianFinder {
    PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());

    PriorityQueue<Integer> right = new PriorityQueue<>();

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(left.size()==0) left.add(num);
       else if(num <= left.peek()){
    left.add(num);
}
else{
    right.add(num);
}
        if(left.size()-right.size()>1){
            right.add(left.poll());
        }
        else if((right.size()-left.size())>1) left.add(right.poll());
    }
    
    public double findMedian() {
    int lsize = left.size();
    int rsize = right.size();
    if((lsize+rsize)%2==0){
        return (left.peek()+right.peek())/2.0;

    }else{
        if(lsize>rsize) return left.peek();
        else return right.peek();
    }
    }
}

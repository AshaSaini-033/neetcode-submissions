class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        List<Integer> list = new ArrayList<>();
        int carry =1;

        for(int i=n-1;i>=0;i--){
            int num  = carry+digits[i];
            carry = num/10;
            list.add(num%10);

        }
        if(carry!=0) list.add(carry);
        int size = list.size();
       int k =0;
       int arr[] = new int[size];
        for(int i = size-1;i>=0;i--){
            arr[k] = list.get(i);
            k++;
        }
        return arr;
    }
}

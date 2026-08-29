class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0")  || num2.equals("0")) return "0";
        int n1 = num1.length();
        int n2 = num2.length();
     int arr[] = new int[n1+n2];
     Arrays.fill(arr,0);
        for(int i=n1-1;i>=0;i--){
            for(int j=n2-1;j>=0;j--){
                int digit1 = num1.charAt(i)-'0';
                int digit2 = num2.charAt(j)-'0';
                int sum = digit1*digit2+arr[i+j+1];

                arr[i+j+1] = sum%10;
                arr[i+j] += sum/10;
            }
        }
        int i=0;
        while(arr[i]==0){
            i++;
        }
        StringBuilder sb = new StringBuilder("");
        for(int it = i;it<arr.length;it++){
            sb.append(arr[it]);
        }
        return sb.toString();
    }
}

class Solution {
    public int reverse(int x) {
        int sign = 1;

        if (x < 0)
            sign = -1;

        long ans = 0;
        x = x*sign;
        while (x != 0) {
            int h = x % 10;
            ans = ans * 10 + h;
            x = x / 10;
        }

        ans = ans * sign;

        if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE)
            return 0;

        return (int) ans;
    }
}
class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        long q = 0;
        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;

        long div = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        while (div >= dvs) {
            long temp = dvs;
            long multiple = 1;
            while (div >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            div -= temp;
            q += multiple;
        }

        q *= sign;

        if (q > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (q < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) q;
    }
}
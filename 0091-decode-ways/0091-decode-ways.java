class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        Arrays.fill(dp, 0);
        if (s.charAt(0) == '0')
            return 0;
        dp[0] = 1;
        for (int i=1; i<=n; i++) {
            if (s.charAt(i-1) != '0')
                dp[i] = dp[i-1];
            if (i>1) {
                int twoDigitNum = (s.charAt(i-1) - '0') + (s.charAt(i-2) - '0')*10;
                if (twoDigitNum >= 10 && twoDigitNum <= 26) {
                    dp[i] += dp[i-2];
                }
            }
        }
        return dp[n];
    }

}
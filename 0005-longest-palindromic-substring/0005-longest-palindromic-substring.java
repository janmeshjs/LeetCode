class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();

        if (len == 0) {
            return "";
        }

        char[] sChars = s.toCharArray();

        int[][] dp = new int[2][len + 1];
        int currRow = 0;
        int maxLen = 0;
        int start = 0;

        for (int i = 0; i <= len; i++) {
            for (int j = len; j >= 0; j--) {
                if (i == 0 || j == len) {
                    dp[currRow][j] = 0;
                } else if (sChars[i - 1] == sChars[j]) {
                    dp[currRow][j] = dp[1 - currRow][j + 1] + 1;
                    int currLen = dp[currRow][j];

                    if (i - 1 == j + currLen - 1 && i - currLen == j && currLen > maxLen) {
                        start = j;
                        maxLen = currLen;
                    }
                } else {
                    dp[currRow][j] = 0;
                }
            }

            currRow = 1 - currRow;
        }

        return s.substring(start, start + maxLen);
    }
}
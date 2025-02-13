class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null) return false;
        int len1 = s.length(), len2 = p.length();
        boolean dp[][] = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for(int i = 1; i <= len2; i++)
            if(p.charAt(i - 1) == '*') dp[0][i] = dp[0][i - 2];
        for(int i = 1; i <= len1; i++){
            char c1 = s.charAt(i - 1);
            for(int j = 1; j <= len2; j++){
                char c2 = p.charAt(j - 1);
                if(match(c1, c2)){
                    dp[i][j] = dp[i - 1][j - 1];
                }else{  // c2 == '*'
                    if(p.charAt(j - 1) == '*'){
                        dp[i][j] = dp[i][j - 2];   //skip current
                        if(j > 1 && match(c1, p.charAt(j - 2)))
                            dp[i][j] |= dp[i - 1][j];
                    }
                }
            }
        }
        return dp[len1][len2];
    }
    private boolean match(char c1, char c2){
        return c2 == '.' || c1 == c2;
    }
}
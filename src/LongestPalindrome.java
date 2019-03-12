public class LongestPalindrome {
    public static int longestPalindrome(String s){
        int n = s.length();
        boolean[][] pal =new boolean[n][n];// pal[i][j]表示s[i...j]是否是回文串
        int maxLen = 0;
        for(int j = 0; j< n; j++){ //i作为终点
            int i = j;//作为起点
            while(i >=0){
                if(s.charAt(i) == s.charAt(j) && (j-i <2 || pal[i+1][j-1])){
                     pal[i][j] =true;
                     maxLen = Math.max(maxLen,j-i+1);
                }
                i--;
            }

        }
       return maxLen;
    }

    public static void main(String[] args) {
        String s = new String("ascdcsdfr");
        System.out.println(longestPalindrome(s));
    }
}

import java.util.Scanner;

public class LongestCommonSubstring {
    static int findLongestCommonSubstring(String str1, String str2) {
        if (str1.length() == 0 || str2.length() == 0) {
            return 0;
        }

        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        int maxLen = 0;

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first string: ");
        String str1 = sc.next();
        System.out.println("Enter second string: ");
        String str2 = sc.next();

        System.out.println("The Longest Common Substring's length is: " + findLongestCommonSubstring(str1, str2));
        sc.close();
    }
}
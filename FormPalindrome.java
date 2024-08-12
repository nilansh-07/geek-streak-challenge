import java.util.Scanner;

public class FormPalindrome {
    static int longestCommonSubsequence(int n, String str1, String str2) {
        // DP table to store lengths of LCS
        int dp[][] = new int[n + 1][n + 1];

        // Initialize the base case
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    // LCS of any string with an empty string is 0
                    dp[i][j] = 0;
                }
            }
        }

        // Filling the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    // If characters match, increase count
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    // Take the maximum value from adjacent cells
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        // Length of the LCS of str1 and str2
        return dp[n][n];
    }

    static int countMin(String str) {
        int size = str.length();

        String rev = new StringBuilder(str).reverse().toString();

        // Minimum deletions to make a string palindrome is equal to size - length of
        // longest palindromic subsequence

        return size - longestCommonSubsequence(size, str, rev);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter any String:");
        String str = sc.next();
        System.out.println("To convert a string into palindrome characters required are:" + countMin(str));
        sc.close();
    }
}

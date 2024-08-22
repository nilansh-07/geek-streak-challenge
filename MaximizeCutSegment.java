public class MaximizeCutSegment {

    static int cutSegment(int n, int x, int y, int z, int[] dp) {
        if (n < 0) {
            return Integer.MIN_VALUE;
        } else if (n == 0) {
            return 0;
        } else if (dp[n] != -1) {
            return dp[n];
        }

        int cutX = cutSegment(n - x, x, y, z, dp);
        int cutY = cutSegment(n - y, x, y, z, dp);
        int cutZ = cutSegment(n - z, x, y, z, dp);

        dp[n] = 1 + Math.max(cutX, Math.max(cutY, cutZ));
        return dp[n];
    }

    public int maximizeCuts(int n, int x, int y, int z) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int result = cutSegment(n, x, y, z, dp);
        return result < 0 ? 0 : result;
    }
}
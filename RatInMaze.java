
public class RatInMaze {

    public RatInMaze() {
        ArrayList ans = new ArrayList();
    }

    private void solve(int i, int j, int n, int m, String str, int[][] vis, int[][] mat) {
        if (i < 0 || j < 0 || i >= n || j >= m || vis[i][j] == 1 || mat[i][j] == 0) {
            return;
        }
        if (i == n - 1 && j == m - 1) {
            ans.add(str);
            return;
        }

        vis[i][j] = 1;
        solve(i + 1, j, n, m, str + 'D', vis, mat);
        solve(i, j + 1, n, m, str + 'R', vis, mat);
        solve(i - 1, j, n, m, str + 'U', vis, mat);
        solve(i, j - 1, n, m, str + 'L', vis, mat);
        vis[i][j] = 0;
    }

    public ArrayList<String> findPath(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        if (mat[0][0] == 0) {
            ArrayList<String> noPath = new ArrayList<>();
            noPath.add("-1");
            return noPath;
        }

        int[][] vis = new int[n][m];
        solve(0, 0, n, m, "", vis, mat);

        return new ArrayList<>(ans);
    }

}

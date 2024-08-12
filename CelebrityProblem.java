public class CelebrityProblem {
    static int celebrity(int mat[][]) {
        int len = mat.length;
        int a = 0;
        int b = len - 1;

        while (a < b) {
            if (mat[a][b] == 1) {
                a++;
            } else {
                b--;
            }
        }

        for (int i = 0; i < len; i++) {
            if (i != a && (mat[a][i] == 1 || mat[i][a] == 0)) {
                return -1;
            }
        }

        return a;
    }

    public static void main(String[] args) {
        int mat[][] = { { 0, 1, 0 },
                { 0, 0, 0 },
                { 0, 1, 0 } };

        System.out.print(celebrity(mat));
    }
}

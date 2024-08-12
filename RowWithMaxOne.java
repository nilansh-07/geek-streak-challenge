public class RowWithMaxOne {
    static int rowWithMax1s(int[][] arr) {
        int index = -1;
        int rows = arr.length;
        int columns = arr[0].length;

        int i = 0, j = columns - 1;

        while (i < rows && j >= 0) {
            if (arr[i][j] == 1) {
                index = i;
                j--;
            } else {
                i++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int arr[][] = { { 0, 1, 1, 1 }, { 0, 0, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 0, 0 } };
        System.out.println("Row " + rowWithMax1s(arr) + " contains maximum 1s.");
    }
}
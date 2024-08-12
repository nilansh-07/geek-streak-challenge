import java.util.Arrays;

public class MaximizeValue {
    static int maximizeValue(int arr[]) {
        Arrays.sort(arr);

        long max = 0;
        long mod = 1000000007;
        for (int i = 0; i < arr.length; i++) {
            max = (max + (arr[i] * (long) i) % mod) % mod;
        }

        return (int) max;
    }

    public static void main(String[] args) {
        int arr[] = { 5, 3, 2, 4, 1 };

        System.out.print("The Maximized value of the array is: " + maximizeValue(arr));
    }
}

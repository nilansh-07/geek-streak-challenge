public class SquareRoot {
    static int findSqrt(int num) {
        if (num == 0 || num == 1) {
            return num;
        }

        int start = 1, end = num;
        int ans = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid * mid == num) {
                return mid;
            } else if (mid * mid > num) {
                end = mid - 1;
            } else {
                ans = mid;
                start = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int num = 36;
        System.out.print("The Square root of " + num + " is: " + findSqrt(num));
    }
}
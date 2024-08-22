public class ProductArrayPuzzle {
    public static long[] productExceptSelf(int nums[]) {
        long[] ans = new long[nums.length];
        Arrays.fill(ans, 0);
        int zeros = 0;
        long product = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros++;
            } else {
                product = product * nums[i];
            }
        }

        if (zeros > 1) {
            return ans;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                ans[i] = product;
            } else if (zeros == 1) {
                ans[i] = 0;
            } else {
                ans[i] = product / nums[i];
            }
        }
        return ans;
    }
}

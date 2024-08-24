public class KnapSack {
    static int findKnapSack(int W1, int wt1[], int val1[], int n) {
        // In case capacity is 0 and there's no value.
        if (n == 0 || W1 == 0) {
            return 0;
        }
        // If the last item's weight less than the capacity of knapsack
        if (wt1[n - 1] <= W1) {
            return Math.max(val1[n - 1] + findKnapSack(W1 - wt1[n - 1], wt1, val1, n - 1),
                    findKnapSack(W1, wt1, val1, n - 1));
        } else if (wt1[n - 1] > W1) { // If the last item's weight more than capacity of knapsack we don't include that
            return findKnapSack(W1, wt1, val1, n - 1);
        }

        return 0;
    }

    public static void main(String[] args) {
        // Capacity of the knapsack
        int W = 4;
        // Values in the knapsack
        int val[] = { 1, 2, 3 };
        // Weight associating to each value
        int wt[] = { 4, 5, 1 };

        int size = val.length;
        int ans = findKnapSack(W, wt, val, size);
        System.out.println("Value " + ans);
    }
}

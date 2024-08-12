import java.util.Arrays;

public class JobSequencing {
    class Job {
        int id, profit, deadline;

        Job(int x, int y, int z) {
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }

    static int[] JobScheduling(Job arr[], int n) {
        Arrays.sort(arr, (a, b) -> (b.profit - a.profit));

        int maxDeadline = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i].deadline > maxDeadline) {
                maxDeadline = arr[i].deadline;
            }
        }

        int[] result = new int[maxDeadline + 1];

        for (int i = 1; i <= maxDeadline; i++) {
            result[i] = -1;
        }

        int maxProfit = 0, countJobs = 0;

        for (int i = 0; i < n; i++) {
            for (int j = arr[i].deadline; j > 0; j--) {
                // Finding the free slot
                if (result[j] == -1) {
                    result[j] = i;
                    countJobs++;
                    maxProfit += arr[i].profit;
                    break;
                }
            }
        }

        int[] ans = new int[2];
        ans[0] = countJobs;
        ans[1] = maxProfit;

        return ans;
    }
}

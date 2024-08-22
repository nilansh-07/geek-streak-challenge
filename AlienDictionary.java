public class AlienDictionary {
    public String findOrder(String[] dict, int n, int k) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indeg = new int[k];

        for (int i = 0; i < k; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            String str1 = dict[i];
            String str2 = dict[i + 1];

            int len = Math.min(str1.length(), str2.length());
            boolean foundDifference = false;
            for (int j = 0; j < len; j++) {
                if (str1.charAt(j) != str2.charAt(j)) {
                    adj.get(str1.charAt(j) - 'a').add(str2.charAt(j) - 'a');
                    indeg[str2.charAt(j) - 'a']++;
                    foundDifference = true;
                    break;
                }
            }
            if (!foundDifference && str1.length() > str2.length()) {
                return "";
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }

        StringBuilder ans = new StringBuilder();
        int count = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            ans.append((char) (node + 'a'));
            count++;

            for (int neighbor : adj.get(node)) {
                indeg[neighbor]--;
                if (indeg[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        if (count != k) {
            return "";
        }

        return ans.toString();
    }
}

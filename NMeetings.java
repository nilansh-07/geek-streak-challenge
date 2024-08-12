import java.util.Collections;

public class NMeetings {

    class Pair {
        int start;
        int end;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static int maxMeetings(int n, int start[], int end[]) {
        ArrayList<Pair> meetings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            meetings.add(new Pair(start[i], end[i]));
        }
        // Sorting the meetings based on ending time
        Collections.sort(meetings, (a, b) -> a.end - b.end);

        int count = 0;
        int endTime = -1;

        for (Pair meeting : meetings) {
            if (meeting.start > endTime) {
                count++;
                endTime = meeting.end;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int n = 6, start[] = { 1, 3, 0, 5, 8, 5 }, end[] = { 2, 4, 6, 7, 9, 9 };
        System.out.print("The Maximum meeting that can be: " + maxMeetings(n, start, end));
    }
}

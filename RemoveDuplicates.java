/*
Given a string str without spaces, the task is to remove all duplicate characters from it, keeping only the first occurrence.

    Note: The original order of characters must be kept the same. 
*/
public class RemoveDuplicates {

    static String removeDups(String str) {

        boolean[] visited = new boolean[256];
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);

            if (!visited[currentChar]) {
                result.append(currentChar);
                visited[currentChar] = true;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String str = "volvo";

        System.out.println(
                "The string after removing duplicates and only keeping the first occurrence chars: " + removeDups(str));
    }
}
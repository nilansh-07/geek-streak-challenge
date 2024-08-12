public class LongestCommonPrefix {
    static String longestCommonPrefix(String[] strArr) {
        if (strArr.length == 0) {
            return "-1";
        }

        String miniLengthStr = strArr[0];
        // Finding the minimum length string
        for (String str : strArr) {
            if (str.length() < miniLengthStr.length()) {
                miniLengthStr = str;
            }
        }

        int minLength = miniLengthStr.length();
        for (int i = 0; i < minLength; i++) {
            char currentChar = miniLengthStr.charAt(i);
            for (String str : strArr) {
                if (str.charAt(i) != currentChar) {
                    String commonPrefix = miniLengthStr.substring(0, i);
                    return commonPrefix.isEmpty() ? "-1" : commonPrefix;
                }
            }
        }

        return miniLengthStr.isEmpty() ? "-1" : miniLengthStr;
    }

    public static void main(String[] args) {

        String strArr[] = { "geeksforgeeks", "geeks", "geek", "geezer" };

        System.out.print("The Longest prefix is: " + longestCommonPrefix(strArr));
    }
}

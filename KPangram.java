/**
 * Checks if a given string can be changed into a pangram after at most k operations.
 * 
 * A pangram is a sentence containing every letter in the English alphabet.
 * 
 * @param str the input string
 * @param k the maximum number of operations allowed
 * @return true if the string can be changed into a pangram, false otherwise
 * 
 * Example:
 *   Input: str = "the quick brown fox jumps over the lazy dog", k = 0
 *   Output: true
 *   Explanation: The string is already a pangram.
 *   
 *   Input: str = "hello world", k = 2
 *   Output: false
 *   Explanation: The string cannot be changed into a pangram with 2 operations.
 */
public class KPangram {
    static boolean isPangram(String str, int k) {
    
        int charCount = 0;
        int[] freq = new int[26];

        for (char ch : str.toCharArray()) {
            if (ch == ' ') {
                continue;
            } else {
                // Storing the frequency of each character
                freq[ch - 'a']++;
                charCount++;
            }
        }

        int count = 0;
        // Character not present

        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) {
                count++;
            }
        }

        if (charCount >= 26 && count <= k) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        String str = "the quick brown fox jumps over the lazy dog";
        int k = 0;

        if (isPangram(str, k)) {
            System.out.println("The given string is Pangram.");
        } else {
            System.out.println("The given string isn't Pangram.");
        }
    }
}
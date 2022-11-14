package arrayAndString;

/**
 * Given a string s, reverse the order of characters in each word within a sentence
 * while still preserving whitespace and initial word order.
 *
 * Example 1:
 * Input: s = "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 *
 * Constraints:
 * 1 <= s.length <= 5 * 10^4
 * s contains printable ASCII characters.
 * s does not contain any leading or trailing spaces.
 * There is at least one word in s.
 * All the words in s are separated by a single space.
 */
public class ReverseWords2 {

    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println("[" + s + "]");
        ReverseWords2 r = new ReverseWords2();
        s = r.reverseWords(s);
        System.out.println("[" + s + "]");
    }

    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int i = 0;
        int j = 0;
        while (j < n) {
            j = i;
            while (j < n && arr[j] != ' ') {
                j++;
            }
            reverse(arr, i, j - 1);
            i = j;
            while (i < n && arr[i] == ' ') {
                i++;
            }
        }
        return new String(arr);
    }

    private void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char temp = arr[end];
            arr[end--] = arr[start];
            arr[start++] = temp;
        }
    }

}

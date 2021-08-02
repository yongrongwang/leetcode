package arrayAndString;

/**
 * Given an input string s, reverse the order of the words. A word is defined as
 * a sequence of non-space characters. The words in s will be separated by at least
 * one space. Return a string of the words in reverse order concatenated by a single
 * space. Note that s may contain leading or trailing spaces or multiple spaces
 * between two words. The returned string should only have a single space separating
 * the words. Do not include any extra spaces.
 *
 * Example 1:
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 *
 * Constraints:
 * 1 <= s.length <= 10^4
 * s contains English letters (upper-case and lower-case), digits, and spaces ' '.
 * There is at least one word in s.
 */
public class ReverseWords {

    public static void main(String[] args) {
        String s = "the   sky is blue";
        System.out.println("[" + s + "]");
        ReverseWords r = new ReverseWords();
        s = r.reverseWords(s);
        System.out.println("[" + s + "]");
    }

    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        reverse(arr, 0, n - 1);
        return cleanAndReverse(arr, n);
    }

    /**
     * 针对每一个单词的操作进行一次循环，先通过指针j和k来删除空格，然后通过指针i和j来反转每一
     * 个单词，最后返回0～j之间的字符
     */
    private String cleanAndReverse(char[] arr, int n) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (k < n) {
            i = j;
            while (k < n && arr[k] == ' ') {
                k++;
            }
            while (k < n && arr[k] != ' ') {
                arr[j++] = arr[k++];
            }
            reverse(arr, i, j - 1);
            while (k < n && arr[k] == ' ') {
                k++;
            }
            if (k < n) {
                arr[j++] = ' ';
            }
        }
        return new String(arr).substring(0, j);
    }

    private void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char temp = arr[end];
            arr[end--] = arr[start];
            arr[start++] = temp;
        }
    }

}

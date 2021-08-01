package arrayAndString;

/**
 * Write a function that reverses a string. The input string is given as an array
 * of characters s.
 *
 * Example 1:
 * Input: s = ['h','e','l','l','o']
 * Output: ['o','l','l','e','h']
 *
 * Constraints:
 * 1 <= s.length <= 10^5
 * s[i] is a printable ascii character.
 */
public class ReverseString {

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        ReverseString r = new ReverseString();
        System.out.println(new String(s, 0, s.length));
        r.reverseString(s);
        System.out.println(new String(s, 0, s.length));
    }

    /**
     * 两个指针同时从两边往中间扫描，每次遇到一个元素就交换，直到两个指针相遇则结束
     */
    public void reverseString(char[] s) {
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            char t = s[i];
            s[i] = s[j];
            s[j] = t;
        }
    }

}

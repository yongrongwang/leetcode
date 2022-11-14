package arrayAndString;

/**
 * Given two binary strings a and b, return their sum as a binary string.
 *
 * Example 1:
 * Input: a = "11", b = "1"
 * Output: "100"
 *
 * Constraints:
 * 1 <= a.length, b.length <= 10^4
 * a and b consist only of '0' or '1' characters.
 * Each string does not contain leading zeros except for the zero itself.
 */
public class AddBinary {

    public static void main(String[] args) {
        String a = new String("100");
        String b = new String("110010");
        AddBinary ab = new AddBinary();
        String c = ab.addBinary(a, b);
        int len1 = a.length();
        int len2 = b.length();
        if (len1 > len2) {
            for (int i = 0; i < len1 - len2; i++) {
                b = " " + b;
            }
        } else if (len1 < len2) {
            for (int i = 0; i < len2 - len1; i++) {
                a = " " + a;
            }
        }
        if (c.length() > Math.max(len1, len2)) {
            a = " " + a;
            b = " " + b;
        }
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    /**
     * 两个字符串同时从右往左扫描，如果当前索引大于等于0，则分别取出当前元素转换为十进制数字后
     * 加上低位进位得到该位的和sum，然后用sum取余2得到该位实际二进制数字，再用sum除以2得到进位，
     * 循环结束后如果进位不为0，则加上最左边的1
     */
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0) {
            sum = carry;
            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) {
            sb.append(1);
        }

        return sb.reverse().toString();
    }

}

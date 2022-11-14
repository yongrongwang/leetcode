/**
 * You are a product manager and currently leading a team to develop a new product. 
 * Unfortunately, the latest version of your product fails the quality check. Since 
 * each version is developed based on the previous version, all the versions after 
 * a bad version are also bad. Suppose you have n versions [1, 2, ..., n] and you 
 * want to find out the first bad one, which causes all the following ones to be 
 * bad. You are given an API bool isBadVersion(version) which returns whether version 
 * is bad. Implement a function to find the first bad version. You should minimize 
 * the number of calls to the API.
 * 
 * Example 1:
 * Input: n = 5, bad = 4
 * Output: 4
 * Explanation:
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * Then 4 is the first bad version.
 * 
 * Constraints:
 * 1 <= bad <= n <= 2^31 - 1
 */

package binarySearch;

public class FirstBadVersion {

    int bad = 2;
    
    public static void main(String[] args) {
        int n = 3;
        FirstBadVersion f = new FirstBadVersion();
        System.out.println(f.firstBadVersion(n));
    }
    
    /**
     * 要查找第一个不合格的产品，需要不断缩小左右边界直到左右边界重合，缩小的过程中，右边界需要
     * 包含不合格的产品，左边界不需要包含不合格的产品
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    boolean isBadVersion(int version) {
        return version == bad;
    }

}

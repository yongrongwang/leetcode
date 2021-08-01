package utils;

public class ArrayUtils {
    public void printArray(int[] nums) {
        printArray(nums, nums.length);
    }

    public void printArray(int[] nums, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public void print2dArray(int[][] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; nums[i] != null && j < nums[i].length; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

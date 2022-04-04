/**
 * Given an integer n, return all the structurally unique BST's (binary search trees),
 * which has exactly n nodes of unique values from 1 to n. Return the answer in
 * any order.
 *
 * Example 1:
 * Input: n = 3
 * Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 *
 * Constraints:
 * 1 <= n <= 8
 */

package recursionI;

import java.util.LinkedList;
import java.util.List;

import binaryTree.TreeNode;

public class GenerateTrees {

    public static void main(String[] args) {
        GenerateTrees g = new GenerateTrees();
        for (int n = 1; n <= 3; n++) {
            System.out.println("n = " + n);
            List<TreeNode> result = g.generateTrees(n);
            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i).val + " ");
            }
            System.out.println();
        }
    }

    /**
     * 目标是将所有可能情况的根结点放入数组
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    /**
     * 因为要找到所有可能的情况，所以根结点的值从1到n进行迭代。又因为左子树的值小于根结点的值，
     * 右子树的值大于根结点的值，如果根结点值rootVal的范围是[start,end]，则构造左右子树的节
     * 点的值的范围分别是[start,rootVal-1]和[rootVal+1,end]。考虑到要返回的左子树和右子树
     * 的构造方式可能不止一种，所以要返回的左子树和右子树应该放到一个数组中，最后从返回的数组中
     * 出每次取一个左子树和一个右子树作为根结点的左孩子和右孩子，并且将根结点放入数组中返回给调
     * 用方法。需要考虑的一个边界条件是当start大于end的时候，这个时候要返回一个包含null的数组
     * 而不是空数组。原因是如果返回的是空数组，则返回到上一层调用方法以后，在迭代左右子树的多种
     * 可能情况的时候会直接跳过，从而导致向数组中添加新节点失败。
     * @param start
     * @param end
     * @return
     */
    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> result = new LinkedList<TreeNode>();
        if (start > end) {
            result.add(null);
            return result;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTree = generateTrees(start, i - 1);
            List<TreeNode> rightTree = generateTrees(i + 1, end);
            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    TreeNode node = new TreeNode(i, left, right);
                    result.add(node);
                }
            }
        }
        return result;
    }

}

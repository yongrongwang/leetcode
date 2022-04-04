/**
 * Given the root of a binary tree, return all duplicate subtrees. For each kind 
 * of duplicate subtrees, you only need to return the root node of any one of them.
 * Two trees are duplicate if they have the same structure with the same node values.
 * 
 * Example 1:
 * Input: root = [1,2,3,4,null,2,4,null,null,4]
 * Output: [[2,4],[4]]
 * 
 * Constraints:
 * The number of the nodes in the tree will be in the range [1, 10^4]
 * -200 <= Node.val <= 200
 */

package hashTable;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {
    int currentId = 1;

    public static void main(String[] args) {
        /*
         *            2
         *           / \
         *          2   2
         *         /   /
         *        3   3
         */
        TreeNode node1 = new TreeNode(3, null, null);
        TreeNode node2 = new TreeNode(2, node1, null);
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node4 = new TreeNode(2, node3, null);
        TreeNode node5 = new TreeNode(2, node2, node4);
        FindDuplicateSubtrees f = new FindDuplicateSubtrees();
        for (TreeNode node : f.findDuplicateSubtrees(node5)) {
            System.out.print(node.val + " ");
        }
    }
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> serialToId = new HashMap<String, Integer>();
        Map<Integer, Integer> idToCount = new HashMap<Integer, Integer>();
        List<TreeNode> result  = new LinkedList<TreeNode>();
        postOrder(root, serialToId, idToCount, result);
        return result;
    }
    
    /**
     * 使用后序遍历将子树序列化成字符串，相同字符串表示的子树重复出现，则将其根结点加入结果，通
     * 过使用id表示左右子树来简化字符串拼接操作
     * @param root
     * @param map
     * @param result
     * @return
     */
    private int postOrder(TreeNode root, Map<String, Integer> serialToId, 
                          Map<Integer, Integer> idToCount, List<TreeNode> result) {
        if (root == null) {
            return 0;
        }
        int leftId = postOrder(root.left, serialToId, idToCount, result);
        int rightId = postOrder(root.right, serialToId, idToCount, result);
        String serial = root.val + "," + leftId + "," + rightId;
        int id = serialToId.getOrDefault(serial, currentId);
        if (id == currentId) {
            currentId++;
        }
        serialToId.put(serial, id);
        int count = idToCount.getOrDefault(id, 0) + 1;
        if (count == 2) {
            result.add(root);
        }
        idToCount.put(id, count);
        return id;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

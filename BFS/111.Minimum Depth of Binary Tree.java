/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

  public int minDepth(TreeNode root) {
    int depth = 0;
    if (root == null) {
      return depth;
    }
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);
    loop:while (!queue.isEmpty()) {
      int size = queue.size();
      depth++;
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        if (node.left == null && node.right == null) {
          break loop;
        }
        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
      }
    }
    return depth;
  }
}

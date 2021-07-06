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

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();

    if (root == null) {
      return result;
    }

    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);
    boolean is_order_left = true;

    while (!queue.isEmpty()) {
      int size = queue.size();
      LinkedList<Integer> level = new LinkedList<Integer>();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        if (is_order_left) {
          level.addLast(node.val);
        }
        if (!is_order_left) {
          level.addFirst(node.val);
        }
        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
      }
      result.add(level);
      is_order_left = !is_order_left;
    }
    return result;
  }
}

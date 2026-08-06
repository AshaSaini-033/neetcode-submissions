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
    int ans = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
       func(root);
       return ans;
    }
    public int func(TreeNode root){
         if(root ==null) return 0;
      int l = func(root.left);
      int r = func(root.right);
      ans = Math.max(ans,l+r);
      return 1+Math.max(l,r);
    }
}

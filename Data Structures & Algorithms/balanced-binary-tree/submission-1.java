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
    public boolean isBalanced(TreeNode root) {
        if(root ==null) return true;

        int l = func(root.left);
        int r = func(root.right);
        if(Math.abs(l-r)>1) return false;
        boolean b1 = isBalanced(root.left);
        boolean b2 = isBalanced(root.right);

        
         return b1&&b2;
      
    }

    public int func(TreeNode root){
        if(root ==null) return 0;
        int lh = 1+func(root.left);
        int rh = 1+func(root.right);

        return Math.max(lh,rh);
    }
}

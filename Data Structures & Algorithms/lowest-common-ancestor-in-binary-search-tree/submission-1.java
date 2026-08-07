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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // if(root==null || root==p || root==q) return root;
        // TreeNode left = lowestCommonAncestor(root.left,p,q);
        // TreeNode right = lowestCommonAncestor(root.right,p,q);

        // if(left==null) return right;
        // else if(right==null) return left;
        // else return root;
TreeNode curr = root;
        while(curr!=null){
       if(curr.val<p.val && curr.val<q.val) curr = curr.right;
       else if(curr.val>p.val && curr.val>q.val) curr = curr.left;
       else return curr;
        }
        return null;
    }
}

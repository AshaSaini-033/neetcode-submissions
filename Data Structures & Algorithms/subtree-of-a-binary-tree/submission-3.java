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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
     if(root == null && subRoot ==null) return true;
     else if(root == null && subRoot!=null ) return false;
     else if(root != null && subRoot ==null)return false;
     else{
            if(isEqui(root,subRoot)) return true;
            else{
                return isSubtree(root.left,subRoot)||              isSubtree(root.right,subRoot);
            }
            
        }
     }


    
    public boolean isEqui(TreeNode p,TreeNode q){
        if(p==null && q==null) return true;
        else if(p!=null && q==null) return false;
        else if(p==null && q!=null) return false;
        else{
            if(p.val!=q.val) return false;
            else{
                boolean b1 = isEqui(p.left,q.left);
                 boolean b2 = isEqui(p.right,q.right);
                return b1&& b2;
            }
        }
    }
}

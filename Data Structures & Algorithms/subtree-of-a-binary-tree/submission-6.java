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
     if(subRoot ==null) return true;
     if(root == null) return false;

     else{
            if(isEqui(root,subRoot)) return true;
            else{
                return isSubtree(root.left,subRoot)||            isSubtree(root.right,subRoot);
            }
            
        }
     }


    
    public boolean isEqui(TreeNode p,TreeNode q){
        if(p==null && q==null) return true;
         if(p!=null && q!=null &&p.val==q.val){
    return isEqui(p.left,q.left)&&isEqui(p.right,q.right);
         }
              return false;
            }

}


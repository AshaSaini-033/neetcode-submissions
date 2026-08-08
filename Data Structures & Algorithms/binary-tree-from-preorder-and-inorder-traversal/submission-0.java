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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> inmap = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inmap.put(inorder[i],i);
        }
        return func(preorder,0,preorder.length-1,inorder,0,inorder.length-1,inmap);

    }
    public TreeNode func(int preorder[],int prestart,int preend,int inorder[],int instart,int inend,HashMap<Integer,Integer> hmap ){
        if(instart>inend ||prestart>preend) return null;
     TreeNode root  = new TreeNode(preorder[prestart]);
     int inroot = hmap.get(root.val);
     int numsleft =inroot-instart; 
     root.left = func(preorder,prestart+1,preend+numsleft,inorder,instart,inroot-1,hmap);

     root.right = func(preorder,prestart+numsleft+1,preend,inorder,inroot+1,inend,hmap);
     return root; 
    }
}

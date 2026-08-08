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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder ans = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode  x  = q.poll();

            if(x==null){ans.append("n"+" ");
            continue;}
            else ans.append(Integer.toString(x.val)+" ");

            q.offer(x.left);
            q.offer(x.right);


        }
        return ans.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
         if(data.equals("n")) return null;
        String arr[] = data.split(" ");
       if(arr[0].equals("n")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
int n = arr.length;
Queue<TreeNode> q =new LinkedList<>();
q.offer(root);
        for(int i=1;i<n;i++){
         TreeNode parent = q.poll();
          if(!arr[i].equals("n")){
      parent.left = new TreeNode(Integer.parseInt(arr[i]));
      q.offer(parent.left);
          }
          if(!arr[++i].equals("n")){
            parent.right = new TreeNode(Integer.parseInt(arr[i]));
            q.offer(parent.right);
          }
        }
        return root;
        
    }
}

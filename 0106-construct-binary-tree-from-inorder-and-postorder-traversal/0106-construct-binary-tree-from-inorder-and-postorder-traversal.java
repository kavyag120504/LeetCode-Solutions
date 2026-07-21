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
     int postorderIndex;
        Map<Integer,Integer> inorderIndexMap =new HashMap<>();
        int []postorder;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
       this.postorder=postorder;
       this.postorderIndex = postorder.length - 1;
       for(int i=0;i<inorder.length;i++){
        inorderIndexMap.put(inorder[i],i);
       }
       return build(0, inorder.length-1);
    }
    TreeNode build(int inorderStart,int inorderEnd){
        if(inorderStart>inorderEnd)
        return null;

        int rootVal=postorder[postorderIndex];
        TreeNode root=new TreeNode(rootVal);
        postorderIndex--;

        int rootIndexInInorder = inorderIndexMap.get(rootVal);



        root.right=build(rootIndexInInorder+1,inorderEnd);
        root.left=build(inorderStart,rootIndexInInorder-1);
        
       return root;
    }
   
}
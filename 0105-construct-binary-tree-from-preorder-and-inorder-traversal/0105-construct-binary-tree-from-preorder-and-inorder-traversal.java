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
    Map<Integer,Integer> inorderIndexMap=new HashMap<>();
    int [] preorder;
    int preorderIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder=preorder;
        for(int i=0;i<inorder.length;i++){
            inorderIndexMap.put(inorder[i],i);
        }
        return build(0,inorder.length-1);

    }
    TreeNode build(int inorderStart, int inorderEnd){
        if(inorderStart>inorderEnd)
        return null;

        int rootVal = preorder[preorderIndex];
        preorderIndex++;
         TreeNode root = new TreeNode(rootVal);
        
        int rootIndexInInorder = inorderIndexMap.get(rootVal);
        
        
        root.left = build(inorderStart, rootIndexInInorder-1);
        
        
        root.right = build(rootIndexInInorder+1,inorderEnd);
        
        return root;
    }
}
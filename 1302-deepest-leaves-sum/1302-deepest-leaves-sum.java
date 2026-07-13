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
    int maxDepth = -1;
    int deepestSum = 0;

    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return deepestSum;
    }

    private void dfs(TreeNode node, int depth) {
       if(node == null)
       return;
       else if(depth>maxDepth){
        maxDepth=depth;
        deepestSum=node.val;
       }
       else if(depth==maxDepth){
          deepestSum+=node.val;
       }
       dfs(node.left,depth+1);
       dfs(node.right,depth+1);
    }
}
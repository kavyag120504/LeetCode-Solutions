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
    long totalSum = 0;
    long maxProduct = 0;
    int MOD=1_000_000_007;
    public int maxProduct(TreeNode node) {
        totalSum=getSum(node);
        multiply(node);
        return (int)(maxProduct%MOD);

    }
    private long getSum(TreeNode node){
        if (node==null){
        return 0;
        }
        return node.val+getSum(node.left)+getSum(node.right);
    }
    private long multiply(TreeNode node){
        if(node==null)
        return 0;
       long left= multiply(node.left);
       long right= multiply(node.right);
       long sum=node.val+left+right;
       long mul= sum*(totalSum-sum);
       maxProduct=Math.max(mul,maxProduct);
       return sum;
    }
}
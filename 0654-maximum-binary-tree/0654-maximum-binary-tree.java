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
    int[] nums;
    
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        this.nums = nums;
        return build(0, nums.length - 1);
    }
    
    TreeNode build(int indexStart, int indexEnd) {
        if (indexStart > indexEnd) return null;
        
        int maxIndex = indexStart;
        for (int i = indexStart; i <= indexEnd; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        
        int rootValue = nums[maxIndex];
        TreeNode node = new TreeNode(rootValue);
        
        node.left = build(indexStart, maxIndex - 1);
        node.right = build(maxIndex + 1, indexEnd);
        
        return node;
    }
}
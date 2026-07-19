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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        
        int maxWidth = 0;
        Queue<Object[]> queue = new LinkedList<>();
        queue.offer(new Object[]{root, 0});   
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            Object[] firstArr = queue.peek();
            int firstIndex = (int) firstArr[1];
            int lastIndex = firstIndex;
            
            for (int i = 0; i < levelSize; i++) {
                Object[] arr = queue.poll();       
                TreeNode node = (TreeNode) arr[0];  
                int currIndex = (int) arr[1];       
                
                int index = currIndex - firstIndex;  
                lastIndex = currIndex;
                
                if (node.left != null) {
                    queue.offer(new Object[]{node.left, 2 * index});
                }
                if (node.right != null) {
                    queue.offer(new Object[]{node.right, 2 * index + 1});
                }
            }
            
            maxWidth = Math.max(maxWidth, lastIndex - firstIndex + 1);
        }
        
        return maxWidth;
    }
}
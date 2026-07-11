class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>(); // fixed typo: LikedList -> LinkedList
        queue.offer(root);
        int c = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> current = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                current.add(node.val);

                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }

            if (c % 2 != 0) {          
                Collections.reverse(current); 
            }
            result.add(current);      
            c++;
        }
        return result;
    }
}
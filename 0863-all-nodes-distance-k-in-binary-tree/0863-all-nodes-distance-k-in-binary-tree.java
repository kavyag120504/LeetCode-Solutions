/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
      HashMap<TreeNode,List<TreeNode>> graph= new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        buildGraph(root,null);
        Queue <TreeNode> queue=new LinkedList<>();
        Set<TreeNode> visited=new HashSet<>();

        queue.offer(target);
        visited.add(target);

        int currDistance=0;

        while(!queue.isEmpty()){
            int levelSize=queue.size();
            if(currDistance==k){
                List <Integer> result=new ArrayList<>();
                for(TreeNode n:queue){
                    result.add(n.val);
                }
                return result;
            }

            for(int i=0;i<levelSize;i++){
                TreeNode curr=queue.poll();
                for (TreeNode neighbor : graph.get(curr)){
                    if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
                }
            }
             currDistance++;
        }
        return new ArrayList<>();
      
    }
    void buildGraph(TreeNode node, TreeNode parent){
       if(node == null)
       return;
       if(!graph.containsKey(node)){
        graph.put(node,new ArrayList<>());

       }
       if(parent!=null){
       graph.get(node).add(parent);
       graph.get(parent).add(node);
       }
       buildGraph(node.left,node);
       buildGraph(node.right,node);
    }
}
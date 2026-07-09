class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Deque <Integer> stack=new ArrayDeque<>();
        int maxArea=0;
        for(int i=0;i<=n;i++){
            int curHeight = (i == n) ? 0 : heights[i];
            while(!stack.isEmpty() && heights[stack.peek()]>curHeight){
                int height=stack.pop();
                int left=stack.isEmpty() ? -1 : stack.peek();
                int right=i;

                maxArea=Math.max(maxArea, (right-left-1)*heights[height])   ;               
            }
            stack.push(i);
        }
        return maxArea;
    }
}
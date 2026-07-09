class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
      int n=temperatures.length;
      Deque <Integer> stack=new ArrayDeque<>();
      int result[]=new int[n];
      for(int i=0;i<n;i++){
        int curr=temperatures[i];
        while(!stack.isEmpty() && temperatures[stack.peek()]<curr){
            int prev=stack.pop();
            result[prev]=i-prev;
        }
        stack.push(i);
      }  
      return result;
    }
}
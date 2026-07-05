class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        PriorityQueue <int []> minHeap = new PriorityQueue<>((a,b)-> a[0]-b[0]);
         for (int row = 0; row < n; row++) {
            minHeap.offer(new int []{matrix[row][0],row,0});
        
         }
         int count =0;
         int result=-1;
         while(count<k){
            int [] curr=minHeap.poll();
            int value=curr[0];int row=curr[1];int col=curr[2];
            result=value;
            count++;
         
         if (col+1<n){
         minHeap.offer(new int[]{matrix[row][col+1],row,col+1});
    }
    }
    return result;
    }
}
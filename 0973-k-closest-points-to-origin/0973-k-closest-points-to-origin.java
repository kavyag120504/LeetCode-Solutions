class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int result[][]=new int[k][2];
        PriorityQueue <int[]>pq=new PriorityQueue<>(
            (a,b)->Integer.compare(
                a[0]*a[0]+a[1]*a[1],
                b[0]*b[0]+b[1]*b[1]
                
            ));
            for(int i=0;i<points.length;i++){
                pq.offer(points[i]);
            }
            int j=0;
            while(j<k){
                result[j]=pq.poll();
                j++;
            }
        return result;
    }
}
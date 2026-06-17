class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int ROWS=grid.length;
        int COLS =grid[0].length;
       if(grid[0][0] == 1 || grid[ROWS-1][COLS-1] == 1)
       return -1;
       
        int []dr={-1, -1, -1,  0,  0, +1, +1, +1};
        int []dc={-1,  0, +1, -1, +1, -1,  0, +1};

       
        boolean [][]visited=new boolean[ROWS][COLS];
        Queue<int[]>queue=new LinkedList<>();
        queue.add(new int[]{0,0});
        visited[0][0]=true;
        int count=1;

        //BFS Loop
        while(!queue.isEmpty()){
            int size=queue.size();
            for (int i = 0; i < size; i++){
            int []curr=queue.poll();
            int r=curr[0];
            int c=curr[1];
            if(r==ROWS-1 && c==COLS-1){
            return count;
            }
            for(int d=0;d<8;d++){
                int nr=r+dr[d];
                int nc=c+dc[d];

                if(nr<0|| nr>=ROWS)
                continue;
                if(nc<0 || nc>=COLS)
                continue;
                if(grid[nr][nc]==1)
                continue;
                if(visited[nr][nc])
                continue;

                //it means it is a valid one and we add it to queue
                visited[nr][nc]=true;
                queue.add(new int[]{nr,nc});
               
            }
            }
            count++;
           
        }
         return -1;
    }
}
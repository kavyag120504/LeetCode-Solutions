class Solution {
    public int maxDistance(int[][] grid) {
      int ROWS=grid.length;
      int COLS=grid[0].length;

      boolean visited[][]=new boolean[ROWS][COLS];
      Queue<int[]> queue=new LinkedList<>();


   int land=0;int water=0;
     for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == 1) {
                    land++;
                    visited[i][j] = true;   
                    queue.add(new int[]{i, j, 0}); 
                } else {
                    water++;
                }
            }
        }

       if (water == 0 || land == 0) return -1;

      int dr[]={-1,1,0,0} ;
      int dc[]={0,0,-1,1} ;
      int maxDist = -1;
      while(!queue.isEmpty()){
       int cur[]=queue.poll();
        int r = cur[0], c = cur[1], d = cur[2];

        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];


            if (nr < 0 || nr >= ROWS) continue;
            if (nc < 0 || nc >= COLS) continue;
            if (visited[nr][nc]) continue;
            if (grid[nr][nc] == 1) continue;

            visited[nr][nc]=true;
            maxDist = d + 1;
            queue.add(new int[] {nr,nc,d+1});
        }

      }
      return maxDist;

    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int ROWS=grid.length;
        int COLS=grid[0].length;

        boolean [][] visited= new boolean [ROWS][COLS];
        Queue <int[]> queue=new LinkedList<>();
        int []dr={-1,+1,0,0};
        int []dc={0,0,-1,+1};
        int count=0;
        
        for(int r=0;r<ROWS;r++){
            for(int c=0;c<COLS;c++){
                if(grid[r][c]==2){
                    queue.add(new int[] {r,c});
                    visited[r][c]=true;
                }
            }
        }


        while(!queue.isEmpty()){
            int size=queue.size();

            for(int i=0;i<size;i++){

            int []curr=queue.poll();
            int r=curr[0];
            int c=curr[1];  
                for(int d=0;d<4;d++){
                    int nr=r+dr[d];
                    int nc=c+dc[d];

                    if(nr < 0 || nr >= ROWS) continue;
                    if(nc < 0 || nc >= COLS) continue;
                    if(visited[nr][nc]) continue;
                    if(grid[nr][nc] != 1) continue; 
                    visited[nr][nc]=true;
                    grid[nr][nc] = 2; 
                    queue.add(new int[]{nr,nc});
                }
            }
            if(!queue.isEmpty()) 
            {
               count++;
            }
            }
    
        for(int i=0;i<ROWS;i++){
            for(int j=0;j<COLS;j++){
                if(grid[i][j]==1)
                return -1;
            }
        }
        return count;

    }
}

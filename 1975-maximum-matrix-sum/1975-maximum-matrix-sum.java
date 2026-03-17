class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum=0;int c=0;int min=Integer.MAX_VALUE;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                int val=matrix[i][j];
                if(val<0)
                 c+=1;
                 min=Math.min(Math.abs(val),min);
                  sum+=Math.abs(val);
                 
                }
            }
            if(c%2==0)
            return sum;
            else
            return (sum-2*min);
        }
    }

class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Prefix sums for rows and columns
        int[][] rowPrefix = new int[m][n + 1];
        int[][] colPrefix = new int[m + 1][n];

        // Diagonal prefix sums
        int[][] diag1 = new int[m + 1][n + 1]; // main diagonal
        int[][] diag2 = new int[m + 1][n + 1]; // anti-diagonal

        // Build prefix sums
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowPrefix[i][j + 1] = rowPrefix[i][j] + grid[i][j];
                colPrefix[i + 1][j] = colPrefix[i][j] + grid[i][j];

                diag1[i + 1][j + 1] = diag1[i][j] + grid[i][j];
                diag2[i + 1][j] = diag2[i][j + 1] + grid[i][j];
            }
        }

        int maxSize = Math.min(m, n);

        // Try larger squares first
        for (int size = maxSize; size >= 2; size--) {
            for (int i = 0; i + size <= m; i++) {
                for (int j = 0; j + size <= n; j++) {

                    int target = rowPrefix[i][j + size] - rowPrefix[i][j];
                    boolean isMagic = true;

                    // Check all rows
                    for (int r = 0; r < size; r++) {
                        int rowSum = rowPrefix[i + r][j + size] - rowPrefix[i + r][j];
                        if (rowSum != target) {
                            isMagic = false;
                            break;
                        }
                    }

                    // Check all columns
                    for (int c = 0; c < size && isMagic; c++) {
                        int colSum = colPrefix[i + size][j + c] - colPrefix[i][j + c];
                        if (colSum != target) {
                            isMagic = false;
                            break;
                        }
                    }

                    // Check diagonals
                    int d1 = diag1[i + size][j + size] - diag1[i][j];
                    int d2 = diag2[i + size][j] - diag2[i][j + size];

                    if (isMagic && d1 == target && d2 == target) {
                        return size;
                    }
                }
            }
        }

        return 1; // single cell is always a magic square
    }
}

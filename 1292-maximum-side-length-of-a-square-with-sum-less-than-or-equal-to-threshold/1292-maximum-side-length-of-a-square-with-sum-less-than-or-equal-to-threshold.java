class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;

        // 1) build prefix sum
        int[][] pre = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                pre[i][j] = mat[i - 1][j - 1]
                          + pre[i - 1][j]
                          + pre[i][j - 1]
                          - pre[i - 1][j - 1];
            }
        }

        int ans = 0;
        int maxLen = Math.min(m, n);

        // 2) try square sizes
        for (int len = 1; len <= maxLen; len++) {
            boolean possible = false;

            for (int i = 0; i + len <= m; i++) {
                for (int j = 0; j + len <= n; j++) {
                    int sum = pre[i + len][j + len]
                            - pre[i][j + len]
                            - pre[i + len][j]
                            + pre[i][j];

                    if (sum <= threshold) {
                        possible = true;
                        break;
                    }
                }
                if (possible) break;
            }

            if (possible) ans = len;
            else break; 
        }

        return ans;
    }
}

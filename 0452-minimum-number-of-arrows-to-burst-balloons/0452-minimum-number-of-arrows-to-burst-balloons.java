class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->Integer.compare(a[0],b[0]));
        int arrows=1;

        int start = points[0][0];
        int end = points[0][1];

        for (int i = 1; i < points.length; i++) {

            // overlap exists
            if (points[i][0] <= end) {
                start = Math.max(start, points[i][0]);
                end = Math.min(end, points[i][1]);
            }

            // no overlap
            else {
                arrows++;
                start = points[i][0];
                end = points[i][1];
            }
        }

        return arrows;
    }
}
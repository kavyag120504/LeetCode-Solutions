class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        if(hour <= dist.length - 1) return -1;
        int l=1;
        int u=10_000_000;
        while(l<u){
            int mid=l+(u-l)/2;
            double s=0;
            for(int i=0;i<dist.length;i++){
                if(i!=dist.length-1)
                s=s+ Math.ceil((double)dist[i]/mid);
                else
                s+=(double)dist[i]/mid;
            }

            if(s<=hour)
            u=mid;
            else
            l=mid+1;
        }
        return u;
    }
}
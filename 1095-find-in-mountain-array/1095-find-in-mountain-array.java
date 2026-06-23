/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        
        // Step 1: Find peak
        int l = 0, u = n - 1;
        while(l < u){
            int mid = l + (u - l) / 2;
            if(mountainArr.get(mid) < mountainArr.get(mid + 1))
                 l=mid+1;
            else
                u=mid;
        }
        int peak = l;

        // Step 2: Binary search on left side (ascending)
        int ans = binarySearch(mountainArr, 0, peak, target, true);
        if(ans != -1) return ans;

        // Step 3: Binary search on right side (descending)
        return binarySearch(mountainArr, peak, n - 1, target, false);
    }

    private int binarySearch(MountainArray mountainArr, int l, int u, int target, boolean ascending){
        while(l <= u){
            int mid = l + (u - l) / 2;
            if(mountainArr.get(mid) == target) return mid;
            if(ascending){
                if(mountainArr.get(mid)<target)
                l=mid+1;
                else
                u=mid-1;
            } else {
                  if(mountainArr.get(mid)<target)
                  u=mid-1;
                  else
                  l=mid+1;
               
            }
        }
        return -1;
    }
}
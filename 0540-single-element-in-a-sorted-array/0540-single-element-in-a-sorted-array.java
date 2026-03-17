class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l=0;int u=nums.length-1;
        while(u>l){
        int mid=l+(u-l)/2;
        if(mid%2==1) 
        mid--;
         if (nums[mid] == nums[mid + 1]){
            l=mid+2;
         }
         else{
            u=mid;
         }
        }
        return nums[l];
    }
}
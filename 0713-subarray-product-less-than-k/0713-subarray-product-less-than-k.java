class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        long m=1;int left=0;int c=0;
        if(k<=1)
        return 0;
        for(int right=0;right<nums.length;right++){
            m*=nums[right];
            while(m>=k){
                m=m/nums[left];
                left++;
            }
            c+=right-left+1;
           
        }
        return c;
    }
}
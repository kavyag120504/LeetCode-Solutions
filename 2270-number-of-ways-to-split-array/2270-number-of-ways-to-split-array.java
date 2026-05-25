class Solution {
    public int waysToSplitArray(int[] nums) {
        long s=0;
        for(int i=0;i<nums.length;i++){
            s+=nums[i];
        }
        int splits=0;
        long presum=0;
        for(int i=0;i<nums.length-1;i++){
          presum+=nums[i];
          if(presum>=s-presum)
          splits++;
        }
        return splits;
    }
}
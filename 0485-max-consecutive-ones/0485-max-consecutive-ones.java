class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int c=0;int max=0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]==0)
            {
                max=Math.max(max,c);
                c=0;
            }
            else{
            c++;
            }
        }
         max=Math.max(max,c);
        return max;
    }
}
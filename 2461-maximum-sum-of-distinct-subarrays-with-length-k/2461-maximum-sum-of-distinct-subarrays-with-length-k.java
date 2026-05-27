class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0;
        long sum=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
         sum+=nums[i];
         map.put(nums[i], map.getOrDefault(nums[i],0)+1);
         if(i>=k ){
          sum-=nums[i-k];
          map.put(nums[i-k],map.get(nums[i-k])-1);
          if(map.get(nums[i-k])==0)
          map.remove(nums[i-k]);
         }
         if(i>=k-1 && map.size()==k){
            maxSum=Math.max(sum,maxSum);
         }
        }
        return maxSum;
    }
}
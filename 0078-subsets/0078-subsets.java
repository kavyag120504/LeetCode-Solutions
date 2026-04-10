class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n=nums.length;
        int total= 1<<n;
        List<List<Integer>> a=new ArrayList<>();
        for(int i=0;i<total;i++){
            List<Integer> b = new ArrayList<>();
            for(int j=0;j<n;j++){
               if((i & (1<<j))!=0)
               b.add(nums[j]);
            }
            a.add(b);
        }
        return a;
    }
}
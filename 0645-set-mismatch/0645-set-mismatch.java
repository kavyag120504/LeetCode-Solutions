class Solution {
    public int[] findErrorNums(int[] nums) {
        int n=nums.length;
        int arr[]=new int[2];
        int expectedsum=0;
        int actualsum=0;
        HashSet <Integer> set=new HashSet<>();
        for(int i=0; i <nums.length;i++){
            if(set.contains(nums[i])){
                arr[0]=nums[i];
            }
            set.add(nums[i]);
            actualsum+=nums[i];
        }
        expectedsum = n*(n+1)/2;
        arr[1]= arr[0]-(actualsum-expectedsum);
        return arr;
    }

}
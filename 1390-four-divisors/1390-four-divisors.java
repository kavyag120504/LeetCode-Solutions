class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum=0;
       for(int i=0;i<nums.length;i++){
        int c=2; int s=1 + nums[i];
        for(int j=2;j *j<=nums[i];j++){
           if(nums[i]%j==0){
             int other = nums[i] /j;
           if (j == other) {
                        c++;
                        s += j;
                    } else {
                        c += 2;
                        s += j + other;
                    }
                }
                         if (c > 4) break;

        }
        if(c==4)
        sum+=s;
        } 
       return sum;
    }
}
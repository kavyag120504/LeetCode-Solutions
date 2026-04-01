class Solution {
    public int minBitFlips(int start, int goal) {
       int  result=start ^ goal;
       int c=0;
       while(result!=0){
           c += result & 1;
           result=result>>1;
       }
       return c;   
        }
}
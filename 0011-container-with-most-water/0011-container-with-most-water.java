class Solution {
    public int maxArea(int[] height) {
        int max=0;
        int right=height.length-1;
        int left=0;
        int area=0;
        while(left<right){
            if(height[right]>height[left]){
            area=height[left]*(right-left);
            left++;
            }
            else{
            area=height[right]*(right-left);
            right--;
            }
            max=Math.max(max,area);
        }
        return max;
    }
}
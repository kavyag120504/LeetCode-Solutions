class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {

        int requiredSum = k * threshold;

        int windowSum = 0;
        int count = 0;

        for(int i = 0; i < arr.length; i++) {

            // add current element
            windowSum += arr[i];

            // remove element if window size exceeds k
            if(i >= k) {
                windowSum -= arr[i-k];
            }

            // check when window size becomes k
            if(i >= k-1 && windowSum >= requiredSum) {
                count++;
            }
        }

        return count;
    }
}
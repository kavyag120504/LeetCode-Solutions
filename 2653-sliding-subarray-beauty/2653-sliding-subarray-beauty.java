class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {

        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int[] freq = new int[101];

        int index = 0;

        for (int i = 0; i < n; i++) {

            freq[nums[i] + 50]++;

            if (i >= k) {
                freq[nums[i - k] + 50]--;
            }

            if (i >= k - 1) {

                int count = 0;
                int beauty = 0;

                for (int val = -50; val < 0; val++) {
                    count += freq[val + 50];

                    if (count >= x) {
                        beauty = val;
                        break;
                    }
                }

                ans[index++] = beauty;
            }
        }

        return ans;
    }
}
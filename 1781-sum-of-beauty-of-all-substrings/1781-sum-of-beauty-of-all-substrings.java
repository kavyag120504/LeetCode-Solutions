class Solution {
    public int beautySum(String s) {
      int beauty=0;
      int n=s.length();
       
        for (int left = 0; left < n; left++) {
        int[] freq = new int[26];
        int maxFreq = 0;
         for (int right = left; right <n; right++) {
            char ch=s.charAt(right);
            freq[ch -'a']++;
            maxFreq = Math.max(maxFreq, freq[ch - 'a']);
              int minFreq = Integer.MAX_VALUE;
            for (int k = 0; k < 26; k++) {
                if (freq[k] > 0) {
                    minFreq = Math.min(minFreq, freq[k]);
                }
            }
            beauty += maxFreq - minFreq;
        }
    }
    return beauty;
    }
}
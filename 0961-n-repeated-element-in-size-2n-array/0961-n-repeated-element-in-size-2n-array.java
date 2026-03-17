import java.util.HashSet;

class Solution {
    public int repeatedNTimes(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (!set.add(num)) { // add() returns false if already present
                return num;
            }
        }
        return -1;
    }
}

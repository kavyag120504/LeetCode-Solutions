class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashSet <Integer> set= new HashSet<>();
       HashMap <Integer,Integer> map= new HashMap<>();
       for(int i=0;i<nums.length;i++){
         map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
       }
       PriorityQueue <Integer> heap = new PriorityQueue<>((a,b)-> map.get(b)-map.get(a));
       heap.addAll(map.keySet());
       int result[]=new int[k];
       for(int i=0;i<k;i++){
        result[i]= heap.poll();
       }
       return result;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set <String> wordSet = new HashSet <>(wordList); 
        if(!wordSet.contains(endWord))
        return 0;

    Queue <String> queue = new LinkedList<>();
    Set <String> visited = new HashSet<>();

    queue.offer(beginWord);
    visited.add(beginWord);
    int steps=1;

    while(!queue.isEmpty()){
        int size=queue.size();
        for(int i=0;i<size;i++){
            String word=queue.poll();

        for(int j=0;j<word.length();j++){
            char[]arr=word.toCharArray();

        for(char ch='a';ch<='z';ch++){
            arr[j]=ch;
            String newWord =new String(arr);

            if(newWord.equals(endWord))
            return steps+1;

            if(wordSet.contains(newWord) && !visited.contains(newWord)){
            visited.add(newWord);
            queue.offer(newWord);

        }
        }
        }
        }
        steps++;
    }
    return 0;
    }
}
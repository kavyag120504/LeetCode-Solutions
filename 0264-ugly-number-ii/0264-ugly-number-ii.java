class Solution {
    public int nthUglyNumber(int n) {
        ArrayList<Integer> list =new ArrayList<>();
        int i2=0;int i3=0;int i5=0;
        list.add(1);
        while (list.size()<n){
            int next=Math.min(
    Math.min(list.get(i2) * 2, list.get(i3) * 3),
    list.get(i5) * 5
);
        list.add(next);
        if(list.get(i2)*2==next)
        i2++;
        if(list.get(i3)*3==next)
        i3++;
        if(list.get(i5)*5==next)
        i5++;

        }
        return list.get(n-1);
    }
}
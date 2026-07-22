class Solution {
    public int digitFrequencyScore(int n) {
        HashMap<Integer,Integer> map = new HashMap<>();
        HashSet<Integer> set= new HashSet<>();
        while(n>=1) {
            int x= n%10;
            set.add(x);
            map.put(x, map.getOrDefault(x,0)+1);
            n= n/10;
        }
        int ans =0;
        for(int i: set) {
            ans += i*map.get(i);
        }

        return ans;
    }
}
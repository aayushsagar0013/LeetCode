class Solution {
    public int maxProduct(int n) {
        List<Integer> ls = new ArrayList<>();

        while(n>=1) {
            ls.add(n%10);
            n=n/10;
        }
        if(ls.size()<=1) return 0;
        Collections.sort(ls);

        return ls.get(ls.size()-1)*ls.get(ls.size()-2);

    }
}
class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();

        for(int i: nums) {
            set.add(i);
        }

        for(int i=1;i<=200; i++) {
            if(!set.contains(i*k)) return i*k;
        }




        return -1;
        
    }
}
class Solution {
    public int removeDuplicates(int[] nums) {

        LinkedHashSet<Integer>  set = new LinkedHashSet<>();
        for(int i : nums) {
            set.add(i);
        }
        int idx =0; 
        int ans = set.size();
        for(int i : set) {
            nums[idx] = i;
            idx++;
        }

    return ans;
    }
}
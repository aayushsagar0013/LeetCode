class Solution {
    public int[] concatWithReverse(int[] nums) {
        int[] ans = new int[nums.length*2];

        for(int i=0; i<nums.length; i++ ) {
            ans[i] = nums[i];
            ans[ans.length-i-1] = nums[i];
        }

        return ans;
    }
}
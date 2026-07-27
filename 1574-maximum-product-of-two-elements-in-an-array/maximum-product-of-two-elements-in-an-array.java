class Solution {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int x = nums[nums.length-1]-1;
        int y = nums[nums.length-2]-1;

        int a = nums[0]-1;
        int b = nums[1]-1;

        return Math.max(x*y, a*b);
        
    }
}
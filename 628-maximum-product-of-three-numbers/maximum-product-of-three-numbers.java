class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int j=1;
        int ans =1;
       
        for(int i=nums.length-1; j<4; j++,i--){
            ans  = ans* nums[i];
        }
         int temp2 =0;
        if(nums[nums.length-1]<0){
             temp2 = nums[0]*nums[1]*nums[2];
        }
        int temp = nums[0]*nums[1]*nums[nums.length-1];
        temp = Math.max(temp,temp2);
        return Math.max(ans,temp);
    }
}
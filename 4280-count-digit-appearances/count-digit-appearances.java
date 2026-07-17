class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        int count =0; 

        for(int i: nums) {

            while(i>=1){
                if(i%10 == digit) count++;
                
                i=i/10;
            }
        }


        return count;
    }
}
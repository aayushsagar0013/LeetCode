class Solution {
    public int largestInteger(int n, int s) {
        int ans=0;
        int d =0;
        while(s>=0 && d<n){
            d++;
            ans = ans *10;
            if(s>9) {
                s = s-9;
                ans += 9;
            } else{
                if(s<=0) {
                   // ans = ans *10;
                } else{
                    ans += s;
                    s = 0;
                }
            }

        }

        if(s !=0) return -1;


        return ans;
    } 
}
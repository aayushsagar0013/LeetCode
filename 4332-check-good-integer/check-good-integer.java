class Solution {
    public boolean checkGoodInteger(int n) {
        int sum = 0;
        int squareSum =0;

        while(n>=1){
            int t = n%10;
            sum += t;
            squareSum = squareSum + (t*t);
                n = n/10;
            if((squareSum- sum)>= 50) return true;
        }

        if((squareSum- sum)>= 50) return true;
        return false;
    }
}
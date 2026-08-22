class Solution {
    public boolean checkDivisibility(int n) {
        double t=(double)n;
        double sum =0;
        int pp = 1;
        while(n>0) {
            sum += n%10;
            pp = pp*(n%10);
            n= n/10;
        }

        if(t%(sum+pp)==0) return true;


        return false;
    }
}
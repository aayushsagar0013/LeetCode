class Solution {
    public String reversePrefix(String s, int k) {
        String ans = "";
        for(int i=0; i<k; i++) {
            ans = s.charAt(i)+ans;
        }

        ans = ans + s.substring(k);


        return ans;
    }
}
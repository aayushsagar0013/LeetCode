class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();

        for(int i=0; i<s.length(); i++ ) {

            char x= s.charAt(i);

            if(x==')' ) {
                String r = "";

                while(st.peek() != '('){
                    r = r+ st.pop();
                } 
                st.pop();

                for(int j=0; j<r.length(); j++ ) {
                    st.push(r.charAt(j));
                }

            } else  {
                st.push(x);
            }
        }
        String ans = "";

        while(st.size()!=0) {
            ans =st.pop() + ans;
        }


        return ans;
    }
}
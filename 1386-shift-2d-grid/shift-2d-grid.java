class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        for(int i=grid.length-1; i>=0;i--) {
            for(int j=grid[0].length-1;j>=0; j--) {
                st.push(grid[i][j]);
            }
        }
        kickBehind(st,grid, k);

        for(int i=grid.length-1; i>=0;i--) {
            List<Integer> ls = new ArrayList<>();
            for(int j=grid[0].length-1;j>=0; j--) {
                ls.add(st.pop());
            }
            ans.add(ls);
        }


        return ans;
    }
    public void kickBehind(Stack<Integer> st, int[][] grid , int k) {
        
         for(int i=grid.length-1; i>=0;i--) {
            for(int j=grid[0].length-1;j>=0; j--) {
                if(k<=0) return;
                st.push(grid[i][j]);
                k--;
            }
        }

        if(k>0) kickBehind(st, grid, k);
    }
}
class Trie {
    ArrayList<String> ls ;
    public Trie() {
       ls =  new ArrayList<>();
    }
    
    public void insert(String word) {
        ls.add(word);
    }
    
    public boolean search(String word) {
        return contains(ls, word);
    }
    
    public boolean startsWith(String prefix) {
        return prefixCount(ls,prefix);
    }
       public boolean contains(List<String> ls, String word) {
        
        for(String s: ls) {
            if(s.equals(word)) return true;
        }

        return false;
    }
    public boolean prefixCount(List<String> words, String p) {
        int count =0;
        for(int i=0; i<words.size(); i++){
            if(check(words.get(i),p)){
                return true;
            }
        }

        return false;
    }
    public boolean check(String s,String p ){
        if(s.length()<p.length()) return false;

        if(s.length()== p.length()) return s.equals(p);

        int i=0;
        for(int j=0; j<s.length(); j++){
            if(s.charAt(j)== p.charAt(i)){
                i++;
                if(i==p.length()) return true;
            }
            else{
                return false;
            }
        }

        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
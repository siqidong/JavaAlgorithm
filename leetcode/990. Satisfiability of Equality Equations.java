/*
Union Find

TC: O(n)
SC: O(n)
*/
class Solution {
    
    class UnionFind {
        Map<Character, Character> map;
        
        public UnionFind() {
            this.map = new HashMap<>();
            for(char c = 'a'; c <= 'z'; c++) {
                map.put(c, c);
            }
        }
        
        public char find(char c) {
            if(map.get(c)==c) {
                return c;
            }
            char father = find(map.get(c));
            map.put(c, father);
            return father;
        }
        
        public void union(char a, char b) {
            char rootA = find(a);
            char rootB = find(b);
            if(rootA!=rootB) {
                map.put(rootA, rootB);
            }
        }
        
        public boolean isConnected(char a, char b) {
            char rootA = find(a);
            char rootB = find(b);
            return rootA==rootB;
        }
        
    }
    
    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind();
        
        for(String equation : equations) {
            char ch1 = equation.charAt(0);
            char ch2 = equation.charAt(3);
            if(equation.charAt(1)=='=') {
                uf.union(ch1, ch2);
            }
        }
        for(String equation : equations) {
            char ch1 = equation.charAt(0);
            char ch2 = equation.charAt(3);
            if(equation.charAt(1)=='!') {
                if(uf.isConnected(ch1, ch2)) {
                    return false;
                }
            }
        }
        return true;
    }
}

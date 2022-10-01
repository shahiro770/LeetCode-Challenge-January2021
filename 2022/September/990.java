class Solution {
    int[] uf = new int[26];
    
    public boolean equationsPossible(String[] equations) {
        for (int i = 0; i < 26; i++) {
            uf[i] = i;
        }
        for (int i = 0; i < equations.length; i++) {
            String e = equations[i];
            if (e.charAt(1) == '=') {
                uf[find(e.charAt(0) - 'a')] = uf[find(e.charAt(3) - 'a')];
            }
        }
        for (int i = 0; i < equations.length; i++) {
            String e = equations[i];
            if (e.charAt(1) == '!') {
                if (uf[find(e.charAt(0) - 'a')] == uf[find(e.charAt(3) - 'a')]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private int find(int let) {
        if (uf[let] == let) {
            return let;
        }
        else {
            uf[let] = find(uf[let]);
            return uf[let];
        }
    }
}
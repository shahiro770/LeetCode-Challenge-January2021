class Solution {
    HashMap<String,Integer> hmp = new HashMap<>();
    HashSet<String> hst = new HashSet<>();
    private int dfs(String str) {
        if(str.length() == 0 || hst.contains(str) == false) return 0;
        if(hmp.get(str)!=null) return hmp.get(str);
        int temp = 0;
        for(int i=0;i<str.length();i++) {
            StringBuilder tmpStr = new StringBuilder(str);
            tmpStr.deleteCharAt(i);
            temp = Math.max(temp,1+dfs(tmpStr.toString()));
        }
        hmp.put(str,temp);
        return temp;
    }
    public int longestStrChain(String[] words) {
        int ans = 0;
        for(String str : words) {
            hst.add(str);
        }
        for(String str : words) {
            ans = Math.max(ans,dfs(str));
        }
        return ans;
    }
}
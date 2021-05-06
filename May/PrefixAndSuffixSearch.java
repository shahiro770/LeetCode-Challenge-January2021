class PrefixAndSuffixSearch {   // WordFilter is what it should be
    HashMap<String, Integer> dic;
    
    public WordFilter(String[] words) {
        dic = new HashMap<String, Integer>();
        
        for (int i = 0; i < words.length; i++) {
            
            ArrayList<String> pres = new ArrayList<String>();
            ArrayList<String> suffs = new ArrayList<String>();
            
            for (int j = 0; j < words[i].length(); j++) {
                pres.add(words[i].substring(0, words[i].length() - j));
                suffs.add(words[i].substring(words[i].length() - j - 1, words[i].length()));
            }    
            
            suffs.add(words[i]);
            
            for (int j = 0; j < pres.size(); j++) {
                for (int k = 0; k < suffs.size(); k++) {
                    dic.put(suffs.get(k) + "#" + pres.get(j), i);
                }
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        String key = suffix + "#" + prefix;
        
        if (dic.containsKey(key)) {
            return dic.get(key);
        }
        
        return -1;
    }
}
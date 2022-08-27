/**
 * May 2021 Day 1
 * 
 * Whenever we see the next number is smaller than the current for the first time, there's two things we can do
 * (you can see this pattern with enough test cases):
 *      1) the number before is less than the next number; make the current number equal to the next number then to maintain order
 *      2) the number before is larger than the next number; make the next number equal to the current to maintain order
 *      3) there is no number before; make the current number equal to the next number (since by definition this is most advantageous)
 * 
 * Obviously, a second array modification will return false
 * 
 * Time Complexity O(n)
 * 
*/

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
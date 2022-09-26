/*
 * Find Duplicate File in System
 * 
 * September 2022
 * Top 80% (44ms)
 *
 * Parse through the strings and store the "directory/file" with the same contents in a map pairing
 * file contents to a list of "directory/file". 
 * 
 * Time complexity: O(n * ((m + 1) * (j + 1))) where n is the of paths, m is the average length of
 * each path, and j is the average length of each file name (at least thats i understand from 
 * the string.split's complexity)
 */

class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, ArrayList<String>> contentsToFiles = new HashMap<String, ArrayList<String>>();
        for (int i = 0; i < paths.length; i++) {
            String[] splitPath = paths[i].split(" ");
            
            for (int j = 1; j < splitPath.length; j++) {
                String[] splitFile = splitPath[j].split("\\(");
                if (contentsToFiles.containsKey(splitFile[1]) == false) {
                    contentsToFiles.put(splitFile[1], new ArrayList<String>());    
                }
                StringBuilder sb = new StringBuilder();
                sb.append(splitPath[0]);
                sb.append("/");
                sb.append(splitFile[0]);
                contentsToFiles.get(splitFile[1]).add(sb.toString());
            }
        }
        
        List<List<String>> sol = new ArrayList<List<String>>();
        for (Map.Entry<String, ArrayList<String>> e : contentsToFiles.entrySet()) {
            if (e.getValue().size() > 1) {
                sol.add(e.getValue());
            }
        }
        
        return sol;
    }
}
/**
 * Feb 2021 Day 5
 * Top 81% this time around (could also clean up the code a bunch)
 * 
 * Dumb way (my way):
 *      Break the problem into various cases and how you'd handle them on the stack
 *          Big indicator on when to take action is on '/' character inputs
 *      Have to deal with the edge case at the very end where a final slash isn't needed (i.e. could end in . or ..)
 * Smart Way:
 *      Do a for loop on the split (String x : path.split("/")) {
 *          Now you can easily compare .. and . and all the other cases by comparing directly to such strings
 *      Rebuild with string builder for maximum optimization
 *      
 * Time complexity is O(n)
 *      Each character only has 2 operations on them at most (push or popped)
 *      Final string assembly is also O(n) cause stringbuilder
 */

class SimplifyPath {
    public String simplifyPath(String path) {
        Deque<Character> stack = new ArrayDeque<Character>();
        char toAdd;
        boolean twoDots = false;
        boolean otherChar = false;
        String finalPath = "";
        
        for (int i = 0; i < path.length(); i++) {
            toAdd = path.charAt(i);
            
            if (toAdd == '/') {
                if (stack.size() == 0) {
                    stack.push(toAdd);
                }
                else if (stack.peekFirst() == '/') {
                    while (stack.size() > 0 && stack.peekFirst() == '/') {
                        stack.pop();
                    }
                    stack.push(toAdd);
                }
                else if (twoDots == true) {
                    int slashCount = 0;
                    while (true) {
                        char top = stack.peekFirst();
                        if (top == '/') {
                            slashCount++;
                            if (slashCount == 2 || stack.size() == 1) {
                                break;
                            }
                        }
                        stack.pop();
                    }
                    twoDots = false;
                }     
                else if (otherChar == false && stack.peekFirst() == '.') {
                    while (stack.peekFirst() != '/') {
                        stack.pop();
                    }
                }
                else {
                    stack.push('/');
                }
                otherChar = false;
            }
            else if (toAdd == '.') { 
                if (stack.peekFirst() == '.' && twoDots == false && otherChar == false) {
                    twoDots = true;
                }
                else if (twoDots == true) {
                    twoDots = false;
                    otherChar = true;
                }
                stack.push('.');
            }
            else {
                otherChar = true;
                twoDots = false;
                stack.push(toAdd);
            }
        }
        if (stack.peekFirst() == '/' && stack.size() != 1) {
            stack.pop();
        }
        else if (stack.peekFirst() == '.' && otherChar == false) {
            if (twoDots == true) {
                int slashCount = 0;
                while (true) {
                    char top = stack.peekFirst();
                    if (top == '/') {
                        slashCount++;
                    }
                    if (stack.size() == 1) {
                        break;
                    }
                    stack.pop();
                    if (slashCount == 2) {
                        break;
                    }
                }
            }
            else {
                while (stack.peekFirst() != '/') {
                    stack.pop();
                }
                if (stack.size() != 1) {
                    stack.pop();
                }
            }
        }
            
        
         StringBuilder sb = new StringBuilder(); 
        while (stack.peekFirst() != null) {
            sb.append(stack.pop());
        }
        
        return sb.reverse().toString();
    }
}
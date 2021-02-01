import java.util.*;

class Day20 {
    public boolean isValid(String s) {
        Stack<Character> bracketStack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == ')' || c == '['
            || c == ']' || c == '{' || c == '}') {
                if (bracketStack.empty() == false && ((c == ')' && bracketStack.peek() == '(')
                   || (c == '}' && bracketStack.peek() == '{')
                   || (c == ']' && bracketStack.peek() == '['))) {     
                    bracketStack.pop();
                }
                else {
                    bracketStack.push(s.charAt(i));
                }
            }
        }
        
        return bracketStack.empty();
    }
}
/*
 * Basic Calculator
 * 
 * Top 83% (9ms)
 * 
 * Important to note in the constraints: THERE IS NO * OR / (I wasted a lot of time).
 * 
 * With any calculator problem, stacks are what come to mind intuitively.
 * There's two levels of complexity here:
 * 1) Doing the basic + or - 
 *      If you view everything as addition, all you need to do is put
 *      the number you were computing on the stack and the sign that came before it (treating
 *      the first number as positive unless a unary - is in front).
 * 2) Handling brackets
 *      Since its all addition and subtraction, brackets can ALMOST be ignored.
 *      We just need to know what unary operator appears before the bracketed sum,
 *      so we can multiply the sum by its operator once we see the closing bracket.
 * 
 * Time Complexity: O(n)
 * */

class Solution {
    public int calculate(String s) {
        s = s.replace(" ", "");
        char[] c = s.toCharArray();
        System.out.println(s);

        int num = 0;
        int sign = 1;
        int operand = 0;
        Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(0);  // we start with a 0 on the stack and add all results to it

        for (int i = 0; i < c.length; i++) {
            if (c[i] >= '0' && c[i] <= '9') {
                num = num * 10 + (c[i] - '0');
            }
            // as soon as we see a symbol, add the current parsed number to the 
            // number on the stack, multiplying it by the sign we saw prior
            else if (c[i] == '+') {
                stack.push(stack.pop() + num * sign);
                sign = 1;
                num = 0;
            }
            // next number will be negative
            // notice how this catches the case where the very first number is negative
            // as it will just flip the sign to -1 while 0 + 0 is computed and pushed 
            else if (c[i] == '-') {
                stack.push(stack.pop() + num * sign);
                sign = -1;
                num = 0;
            }
            // push the sign of the quantity so we can multiply it in once done, as well as a
            // 0 to be treated as a starting sum
            else if (c[i] == '(') {
                stack.push(sign);
                stack.push(0);
                sign = 1;
                num = 0;
            }
            // pop thrice, once to finish adding the bracketed quantity, a second time to multiply  
            // the bracketed quantity's sign, and a third time to add it to the overall sum
            else if (c[i] == ')') {
                int stackNum = (stack.pop() + num * sign) * stack.pop();
                stack.push(stackNum + stack.pop());
                sign = 1;
                num = 0;
            }
        }
        // after the last iteration, there will be the computed num that hasn't been added to the stack
        // so do so before returning the answer
        return stack.pop() + num * sign;
    }
}
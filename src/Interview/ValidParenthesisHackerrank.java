package Interview;
// https://www.hackerrank.com/challenges/java-stack/problem?isFullScreen=true

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;


class ValidParenthesisHackerrank {

    public static void main(String []argh) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.next();
            //Complete the code
            boolean isMatch = true;
            Deque<Character> stack = new ArrayDeque<>();
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);

                if (c == '{' || c == '[' || c == '(') {
                    stack.offerFirst(c);
                } else {  // right parenthesis
                    if (stack.peekFirst() != null) {
                        char top = stack.peekFirst();

                        if (top == '{' && c == '}' || top == '[' && c == ']' || top == '(' && c == ')') {
                            stack.pollFirst();
                        } else {  // top != null && top != c     "左右括号不匹配"
                            isMatch = false;
                            break;
                        }
                    } else {  // top == null  栈顶是空的情况 && c = 右括号    "stack is empty && 来了右括号，没有左括号"
                        isMatch = false;
                        break;
                    }
                }
            }
            System.out.println(stack.isEmpty() && isMatch ? "true" : "false");
        }
    }
}

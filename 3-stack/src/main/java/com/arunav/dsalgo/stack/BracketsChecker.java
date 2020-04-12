package com.arunav.dsalgo.stack;

public class BracketsChecker {

    private Stack<Character> bracketStack;
    private String inputString;

    public BracketsChecker(String inputString) {
        this.inputString = inputString;
        this.bracketStack = new Stack<Character>(inputString.length());
    }

    public String check() {

        String message = "VALID EXPR: All Parenthesis are matching";
        for (int i = 0; i < inputString.length(); i++) {
            Character ch = inputString.charAt(i);
            switch (ch) {
                /* When starting brackets encountered push it onto stack */
                case '(':
                case '{':
                case '[':
                    bracketStack.push(ch);
                    break;

                /* When closing brackets encountered pop the latest item from stack and check if it has a matching
                parenthesis on top of the stack */
                case ')':
                case '}':
                case ']':
                    if (!bracketStack.isEmpty()) {
                        Character popChar = bracketStack.pop();
                        if ((ch == ')' && popChar == '(') ||
                                (ch == '}' && popChar == '{') ||
                                (ch == ']' && popChar == '['))
                            break;
                        else
                            return "INVALID EXPR: Unmatched parenthesis " + ch + " at position " + i;
                    } else {
                        return "INVALID EXPR: Missing starting parenthesis ";
                    }

                default:
                    break;
            }
        }

        if (!bracketStack.isEmpty())
            message = "INVALID EXPR: Missing right parenthesis ";

        return message;
    }
}

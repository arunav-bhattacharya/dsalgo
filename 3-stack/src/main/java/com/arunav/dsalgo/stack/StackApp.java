package com.arunav.dsalgo.stack;

public class StackApp {

    public static void main(String[] args) {
        testIntegerStack();
        stringReverser();
        bracketsChecker();
    }

    private static void testIntegerStack() {
        /* Stack Push, Pop & Peek examples */
        Stack<Integer> integerStack = new Stack<Integer>(3);
        integerStack.push(10);
        integerStack.push(20);
        integerStack.push(30);
        integerStack.push(40);
        System.out.println("Peeked=" + integerStack.peek());

        while (!integerStack.isEmpty())
            System.out.println("Popped=" + integerStack.pop());
    }

    private static void stringReverser() {
        /* Reversing a String example */
        String inputString = "Hello World";
        StringReverser reverser = new StringReverser(inputString);
        System.out.println(inputString + " reversed as " + reverser.reverse());
    }

    private static void bracketsChecker() {
        /* Brackets Checker */
        String inputExpr = "({12-9} + 9 + 4]*(143 - {432.89 * {32/3 * [62 - 3]} + 82}) + 99)";
        BracketsChecker bracketsChecker = new BracketsChecker(inputExpr);
        System.out.println(bracketsChecker.check());
    }
}

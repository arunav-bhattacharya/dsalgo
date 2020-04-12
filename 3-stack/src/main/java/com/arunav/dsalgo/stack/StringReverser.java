package com.arunav.dsalgo.stack;

public class StringReverser {

    private Stack<Character> characterStack;
    private String string;

    public StringReverser(String string) {
        this.string = string;
        this.characterStack = new Stack<Character>(string.length());
    }

    public String reverse() {
        String output = "";
        for (int i = 0; i < this.string.length(); i++)
            characterStack.push(string.charAt(i));
        while (!characterStack.isEmpty())
            output = output + characterStack.pop();
        return output;
    }
}

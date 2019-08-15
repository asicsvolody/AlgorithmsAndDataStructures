package ru.yakimov.FlipLines;

import ru.yakimov.stack.Stack;
import ru.yakimov.stack.StackImpl;

public class FlipLines {

    public static String flipString(String str){
        Stack<Character> characterStack = new CharStack(str);

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i <str.length() ; i++) {
            stringBuilder.append(characterStack.pop());
        }
        return stringBuilder.toString();

    }

    private static class CharStack extends StackImpl<Character>{
        private CharStack(String str) {
            super(str.length());
            pushAllChar(str);
        }
        private void pushAllChar(String str){
            for (char c : str.toCharArray() ) {
                super.push(c);
            }
        }
    }
}

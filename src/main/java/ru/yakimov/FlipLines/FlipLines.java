package ru.yakimov.FlipLines;

import ru.yakimov.stack.StackImpl;

public class FlipLines {

    public static String flipString(String str){
        return new CharStack(str).getAllInSting();
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

        private String getAllInSting (){
            StringBuilder stringBuilder = new StringBuilder(size());
            for (int i = 0; i < stringBuilder.capacity(); i++) {
                stringBuilder.append(pop());
            }
            return stringBuilder.toString();
        }
    }
}

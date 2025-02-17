package com.app;

public class ReverseTheWords {

    //Input: s = " the sky is blue "
    //Output: "blue is sky the"

    public String reverseWords(String s) {

        //split the string by space
        String[] words = s.trim().split("\\s+");

        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i != 0) {
                reversed.append(" ");
            }
        }
        return reversed.toString();
    }
}

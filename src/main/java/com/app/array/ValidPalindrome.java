package com.app.array;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {

        //convert text to alphanumeric
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }

        String original = sb.toString();
        return original.contentEquals(sb.reverse());
    }
}

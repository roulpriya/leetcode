package com.app;

public class ReverseVowelsOfString {

    public static void main(String[] args) {
        String s = "IceCream";
        System.out.println(reverseVowels(s));
    }

    static String reverseVowels(String s) {

        // IceCream -> AceCreIm

        // Convert to charArray
        char[] c = s.toCharArray();

        // Approaches
        // 1. Two pointer approach
        // 2. Stack approach

        // Two pointer approach
        int i = 0;
        int j = s.length() - 1;

        //Assign i to 0 and j to length - 1, iterate until i < j, if i is vowel and j is vowel then swap

        while (i < j) {
            if (isVowel(c[i]) && isVowel(c[j])) {
                char temp = c[i];
                c[i] = c[j];
                c[j] = temp;
                i++;
                j--;
            }

            if (!isVowel(c[i])) {
                i++;
            }

            if (!isVowel(c[j])) {
                j--;
            }
        }

        return String.valueOf(c);

    }

    private static boolean isVowel(char c) {
        //convert char to lowercase and check vowels
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }


}

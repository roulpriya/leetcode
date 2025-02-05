package com.app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        System.out.println(areAlmostEqual(s1, s2));
        System.out.println(optimalSolutionForAreAlmostEqual(s1, s2));

    }

    private static boolean areAlmostEqual(String s1, String s2) {
        char[] c = s1.toCharArray();

        if (s1.equals(s2)) {
            return true;
        }

        if (s1.length() != s2.length()) {
            return false;
        }

        //Swap the char and if the string is equal then return true
        for (int i = 0; i < s1.length(); i++) {
            for (int j = i + 1; j < s1.length(); j++) {
                char temp = c[i];
                c[i] = c[j];
                c[j] = temp;

                if (s2.equals(String.valueOf(c))) {
                    return true;
                }

                c[j] = c[i];
                c[i] = temp;
            }
        }
        return false;
    }

    //Another approach
    private static boolean optimalSolutionForAreAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        if (s1.length() != s2.length()) {
            return false;
        }

        int index = -1;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (index == -2) {
                    return false;
                }
                if (index == -1) {
                    index = i;
                } else if (s1.charAt(index) == s2.charAt(i) && s2.charAt(index) == s1.charAt(i)) {
                    index = -2;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}

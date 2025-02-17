package com.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseVowelsOfStringTest {


    ReverseVowelsOfString reverseVowelsOfString = new ReverseVowelsOfString();

    @Test
    void testReverseVowelsOfString() {
        ReverseVowelsOfString reverseVowelsOfString = new ReverseVowelsOfString();
        assertEquals("holle", reverseVowelsOfString.reverseVowels("hello"));
        assertEquals("leotcede", reverseVowelsOfString.reverseVowels("leetcode"));
        assertEquals("Aa", reverseVowelsOfString.reverseVowels("aA"));
    }

    @Test
    void testReverseVowelsOfString2() {
        ReverseVowelsOfString reverseVowelsOfString = new ReverseVowelsOfString();
        assertEquals("AceCreIm", reverseVowelsOfString.reverseVowels("IceCreAm"));
    }

    @Test
    void testReverseVowelsOfString3() {
        ReverseVowelsOfString reverseVowelsOfString = new ReverseVowelsOfString();
        assertEquals("ia", reverseVowelsOfString.reverseVowels("ai"));
    }

}
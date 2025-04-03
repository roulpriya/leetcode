package com.app.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesisTest {

    @Test
    void isValid() {
        ValidParenthesis validParenthesis = new ValidParenthesis();
        assertTrue(validParenthesis.isValid("()"));
        assertTrue(validParenthesis.isValid("()[]{}"));
        assertFalse(validParenthesis.isValid("(]"));
        assertFalse(validParenthesis.isValid("([)]"));
        assertTrue(validParenthesis.isValid("{[]}"));
    }

}

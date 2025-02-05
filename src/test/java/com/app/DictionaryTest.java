package com.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DictionaryTest {

    @Test
    void testDictionary() {
        Dictionary<String, String> dictionary = new Dictionary<>();
        dictionary.set("key1", "value1");
        dictionary.set("key2", "value2");
        dictionary.set("key3", "value3");

        assertEquals("value1", dictionary.get("key1").get());
        assertEquals("value2", dictionary.get("key2").get());
        assertEquals("value3", dictionary.get("key3").get());

        dictionary.set("key1", "value4");
        assertEquals("value4", dictionary.get("key1").get());

        dictionary.set("key1", "value1");
        assertEquals("value1", dictionary.get("key1").get());

        assertEquals(3, dictionary.size());
    }

}
package com.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {

    @Test
    void testArrayList() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("element1");
        arrayList.add("element2");
        arrayList.add("element3");

        assertEquals("element1", arrayList.get(0).get());
        assertEquals("element2", arrayList.get(1).get());
        assertEquals("element3", arrayList.get(2).get());

        arrayList.set(0, "element4");
        assertEquals("element4", arrayList.get(0).get());

        arrayList.set(0, "element1");
        assertEquals("element1", arrayList.get(0).get());

        assertEquals(3, arrayList.size());
    }

}
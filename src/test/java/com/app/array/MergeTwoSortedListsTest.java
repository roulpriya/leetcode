package com.app.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeTwoSortedListsTest {

    @Test
    void mergeTwoSortedLists() {
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode mergedList = mergeTwoSortedLists.mergeTwoLists(list1, list2);

        assertEquals(1, mergedList.val);
        assertEquals(2, mergedList.next.val);
        assertEquals(3, mergedList.next.next.val);
        assertEquals(4, mergedList.next.next.next.val);
    }

}

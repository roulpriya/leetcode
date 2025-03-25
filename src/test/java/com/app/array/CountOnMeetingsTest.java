package com.app.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountOnMeetingsTest {

    @Test
    void countOnMeeting() {
        int days = 8;
        //[[3,4],[4,8],[2,5],[3,8]]
        int[][] meetings = {{3,4}, {4,8}, {2,5}, {3,8}};

        assertEquals(1, CountOnMeetings.countOnMeetings(days, meetings));
    }

    @Test
    void countOnMeeting2() {
        //[[3,49],[23,44],[21,56],[26,55],[23,52],[2,9],[1,48],[3,31]]
        int days = 57;
        int[][] meetings = {{3,49}, {23,44}, {21,56}, {26,55}, {23,52}, {2,9}, {1,48}, {3,31}};

        assertEquals(1, CountOnMeetings.countOnMeetings(days, meetings));
    }

}

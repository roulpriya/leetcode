package com.app.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * You are given a positive integer days representing the total number of days an employee is available for work (starting from day 1). You are also given a 2D array meetings of size n where, meetings[i] = [start_i, end_i] represents the starting and ending days of meeting i (inclusive).
 *
 * Return the count of days when the employee is available for work but no meetings are scheduled.
 *
 * Note: The meetings may overlap.
 */
public class CountOnMeetings {
    public static void main(String[] args) {
        int days = 10;
        int[][] meetings = {{5, 7}, {1,3}, {9, 10}};

        int countOnMeetings = countOnMeetings(days, meetings);
        System.out.println(countOnMeetings);
    }

    public static int countOnMeetings(int days, int[][] meetings) {

        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        int availableDays = 0;
        int lastEndDay = 0;

        for(int[] meeting: meetings) {
            int start = Math.max(meeting[0], lastEndDay);
            int end = meeting[1];

            if(end < lastEndDay) {
                continue;
            }

            end = Math.min(end, days);

            if (start > lastEndDay + 1) {
                availableDays += start - lastEndDay - 1;
            }
            lastEndDay = end;
        }

        if(lastEndDay < days) {
            availableDays += days - lastEndDay;
        }

        return availableDays;
    }
}

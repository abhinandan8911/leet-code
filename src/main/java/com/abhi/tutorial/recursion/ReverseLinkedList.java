package com.abhi.tutorial.recursion;

// https://leetcode.com/explore/learn/card/recursion-i/251/scenario-i-recurrence-relation/2378/

import com.abhi.tutorial.model.ListNode;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

}

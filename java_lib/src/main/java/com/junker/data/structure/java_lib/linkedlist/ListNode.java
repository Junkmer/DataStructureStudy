package com.junker.data.structure.java_lib.linkedlist;

/**
 * @Author Junker
 * @ClassName ListNode
 * @date 2023/8/3 15:44
 * @Version 1.0
 * @Description TODO
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

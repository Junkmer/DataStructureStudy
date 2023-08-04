package com.junker.data.structure.java_lib.linkedlist;

import java.util.Random;

/**
 * @Author Junker
 * @ClassName Solution
 * @date 2023/8/3 14:46
 * @Version 1.0
 * @Description TODO
 */


class Solution {


    public static ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }

        if (head == null){
            return null;
        }

        ListNode prev = head;
        while (prev.next != null){
            if (prev.next.val == val){
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            }else
                prev = prev.next;
        }
        return head;
    }

    //不使用虚拟头节点
    private static ListNode notUseVirtualHeadNode(ListNode head, int val){
        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }

        if (head == null){
            return null;
        }

        ListNode prev = head;
        while (prev.next != null){
            if (prev.next.val == val){
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            }else
                prev = prev.next;
        }
        return head;
    }

    //使用虚拟头节点
    private static ListNode useVirtualHeadNode(ListNode head, int val){
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode perv = dummyHead;
        while (perv.next != null){
            if (perv.next.val == val){
                perv.next = perv.next.next;
            }else
                perv = perv.next;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        Random random = new Random();
        ListNode perv = listNode;
        for (int i = 0; i < 12; i++) {
            perv.val = i % 4 == 0 ? 4 : random.nextInt(10);
            perv.next = new ListNode();
            perv = perv.next;
        }
        System.out.println(toNodeString(listNode));
        ListNode listNode1 = removeElements(listNode, 4);
        System.out.println(toNodeString(listNode1));
    }

    public static String toNodeString(ListNode node) {
        StringBuilder builder = new StringBuilder();
        builder.append("ListNode:[");
        while (node != null) {
            builder.append(node.val);
            node = node.next;
            if (node != null) {
                builder.append(",");
            }
        }
        builder.append("]");
        return builder.toString();
    }
}

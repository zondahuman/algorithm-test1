package com.abin.lee.algorithm.basic.chain.reverse;

import com.abin.lee.algorithm.common.util.JsonUtil;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by abin on 2018/3/23 16:48.
 * algorithm-test1
 * com.abin.lee.algorithm.test.basic.chain
 * https://www.cnblogs.com/zhengcj/p/7494089.html
 * https://leetcode.com/problems/linked-list-cycle/solution/
 * https://blog.csdn.net/thefutureisour/article/details/8174313
 */
public class SingleChainRing {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node3;
        //这里注销掉，因为是一个环，打印的时候找不到结束点，栈溢出
//        System.out.println("node1 = " + JsonUtil.toJson(node1));

        Boolean reverseLoop = haveRing(node1);
//        Boolean reverseLoop = haveRings(node1);
        System.out.println("reverseLoop = " + JsonUtil.toJson(reverseLoop));
        Integer ringLength = ringLength(node1);
        System.out.println("ringLength = " + JsonUtil.toJson(ringLength));
        Node entranceNode = entranceNode(node1);
        System.out.println("entranceNode = " + JsonUtil.toJson(entranceNode.value));
        Boolean hasCycle = hasCycle(node1);
//        Boolean hasCycle = hasCycles(node1) ;
//        System.out.println("hasCycle = " + JsonUtil.toJson(hasCycle));

    }

    /**
     * 链表是否有环
     *
     * @param root
     * @return
     */
    public static Boolean haveRing(Node root) {
        Node slow = root;
        Node fast = root;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    /**
     * 链表环的长度
     * @param root
     * @return
     */
    public static int ringLength(Node root) {
        Node slow = root;
        Node fast = root;
        boolean first = false;
        int size = 0;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast && !first) {
                break;
            }
        }
        fast = fast.next;
        while (slow != fast) {
            fast = fast.next;
            ++size;
        }
        return size;
    }

    /**
     * 单链表环的入口单链表环的入口
     * @param root
     * @return
     */
    public static Node entranceNode(Node root) {
        Node slow = root;
        Node fast = root;
        boolean first = false;
        int size = 0;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast && !first) {
                break;
            }
        }
        fast = root;
        while (null != fast) {
            if(slow == fast)
                return fast;
            fast = fast.next;
            slow = slow.next;
        }
        return null;
    }




    /**
     * 链表是否有环
     * 使用追赶的方法，设定两个指针slow、fast，均从头指针开始，每次分别前进1步、2步。如存在环，则两者相遇；如不存在环，fast遇到NULL退出。其中主要的思想就是“环形相遇追及问题”，理解上应该不复杂。
     *
     * @param head
     * @return
     */
    public static Boolean haveRings(Node head) {
        //单链表为空时，单链表没有环, 单链表中只有头结点，而且头结点的next为空，单链表没有环
        if (null == head || null == head.next)
            return false;
        Node slow = head.next; //slow表示从头结点开始每次往后走一步的指针
        Node fast = head.next.next; //fast表示从头结点开始每次往后走两步的指针
        while (null != fast && null != fast.next) { //fast不为空执行while循环
            if (slow == fast) {//slow与fast相等，单链表有环
                System.out.println("slow=" + slow.value);
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }


    public static boolean hasCycle(Node head) {
        Set<Node> nodesSeen = new HashSet<Node>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }

    public static boolean hasCycles(Node head) {
        if (head == null || head.next == null) {
            return false;
        }
        Node slow = head;
        Node fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }


    @Setter
    @Getter
    public static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }


}

package com.abin.lee.algorithm.basic.chain.reverse;

import com.abin.lee.algorithm.common.util.JsonUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by abin on 2018/3/23 16:48.
 * algorithm-test1
 * com.abin.lee.algorithm.test.basic.chain
 * https://www.cnblogs.com/zhengcj/p/7494089.html
 * 链表是否相交
 */
public class SingleChainCross {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node1.next = node2 ;
        node2.next = node3 ;
        node3.next = node4 ;
        node4.next = node5 ;
        node5.next = node6 ;
        node6.next = node7 ;
        node7.next = node2 ;
        System.out.println("node1 = " + JsonUtil.toJson(node1));

//        Node middle = searchMiddle(node1) ;
//        System.out.println("middle = " + JsonUtil.toJson(middle));
        Boolean reverseLoop = haveRing(node1) ;
        System.out.println("reverseLoop = " + JsonUtil.toJson(reverseLoop));



    }

    public static Boolean haveRing(Node root){
        Node slow = root ;
        Node fast = root ;
        while(fast != null && fast.next != null){
            slow = slow.next ;
            fast = fast.next.next ;
            if(slow == fast)
                return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }



    @Setter
    @Getter
    public static class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value ;
        }
    }







}

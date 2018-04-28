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
public class SingleChainIntersection {

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

        Node node11 = new Node(11);
        Node node12 = new Node(12);
        node11.next = node12 ;
        node12.next = node3;

        System.out.println("node1 = " + JsonUtil.toJson(node1));
        System.out.println("node11 = " + JsonUtil.toJson(node11));

        Boolean listIntersection = listIntersection(node1, node11) ;
        System.out.println("listIntersection = " + JsonUtil.toJson(listIntersection));
    }

    public static Boolean listIntersection(Node param1, Node param2){
        Node first = param1 ;
        Node second = param2 ;
        Node fEnd = null;
        while(first.next != null){
            first = first.next ;
        }
        fEnd = first;
        Node sEnd = null;
        while(second.next != null){
            second = second.next ;
        }
        sEnd = second;
        if(fEnd == sEnd)
            return true;
        return false;
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

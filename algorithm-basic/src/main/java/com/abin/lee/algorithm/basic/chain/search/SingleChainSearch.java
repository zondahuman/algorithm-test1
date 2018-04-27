package com.abin.lee.algorithm.basic.chain.search;

import com.abin.lee.algorithm.test.util.JsonUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by abin on 2018/3/23 16:48.
 * algorithm-test1
 * com.abin.lee.algorithm.test.basic.chain
 * https://blog.csdn.net/cpcpcp123/article/details/72649007
 */
public class SingleChainSearch {

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

        Node middle = searchMiddle(node1) ;
        System.out.println("middle = " + JsonUtil.toJson(middle));
        Node reverseLoop = reverseLoop(node1) ;
        System.out.println("reverseLoop = " + JsonUtil.toJson(reverseLoop));



    }

    public static Node searchMiddle(Node root){
        Node slow = root ;
        Node fast = root ;
        while(fast != null && fast.next != null){
            slow = slow.next ;
            fast = fast.next.next ;
        }
        return slow;
    }

    /**
     *  链表反转递归
     * @return
     */
    public static Node reverseRecursive(Node root){
        if(null == root)
            return null;
        Node result = reverseRecursive(root.next);

        return null;
    }

    /**
     * 链表反转循环
     * @param root
     * @return
     */
    public static Node reverseLoop(Node root){
        if(null == root)
            return null;
        Node previous = root ;
        Node current = root.next ;
        Node temp = null ;
        while(null != current){
            temp = previous ;
            previous = current ;
            current = current.next;
            current.next = temp;
        }

        return current;
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

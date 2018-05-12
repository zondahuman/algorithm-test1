package com.abin.lee.algorithm.basic.binarytree;

import com.abin.lee.algorithm.common.util.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayDeque;
import java.util.concurrent.DelayQueue;

/**
 * Created by abin on 2018/5/11 16:48.
 * algorithm-test1
 * com.abin.lee.algorithm.basic.binarytree
 */
public class BinaryTreeMirror {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3, node1, node2);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6, node4, node5);
        Node node7 = new Node(7, node6, node3);
        System.out.println("mirrorNode1---before = " + JsonUtil.toJson(node7));

//        Node mirrorNode1 = mirrorRecursive(node7);
//        System.out.println("mirrorNode1---after = " + JsonUtil.toJson(mirrorNode1));

        mirrorCycle(node7);
        System.out.println("mirrorNode2---after = " + JsonUtil.toJson(node7));

//        mirrorCycle(node7);
//        System.out.println("mirrorNode3---after = " + JsonUtil.toJson(node7));
    }

    public static Node mirrorRecursive(Node root){
        if(null == root)
            return null;
        Node node = root.left ;
        root.left = root.right;
        root.right = node ;
        mirrorRecursive(root.left);
        mirrorRecursive(root.right);
        return root;
    }

    public static Node mirrorCycle(Node root){
        if(null == root)
            return null;
        ArrayDeque<Node> stack = new ArrayDeque<Node>();
        stack.push(root);
        Node current = null;
        while(!stack.isEmpty()){
           current = stack.pop();
           if(null != current.left || null != current.right){
               Node temp = current.left;
               current.left = current.right;
               current.right = temp;
           }
           if(null != current.left)
               stack.push(current.left);
           if(null != current.right)
               stack.push(current.right);
       }
        return root;
    }









    @Setter
    @Getter
    @AllArgsConstructor
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int value) {
            this.value = value;
        }
    }
}

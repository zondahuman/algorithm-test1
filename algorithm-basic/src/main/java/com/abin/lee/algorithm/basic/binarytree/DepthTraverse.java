package com.abin.lee.algorithm.basic.binarytree;

import com.abin.lee.algorithm.common.util.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Stack;

/**
 * Created by abin on 2018/5/11 21:06.
 * algorithm-test1
 * com.abin.lee.algorithm.basic.binarytree
 * 深度遍历
 */
public class DepthTraverse {
    public static void main(String[] args) throws InterruptedException {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3, node1, node2);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6, node4, node5);
        Node node7 = new Node(7, node6, node3);
        System.out.println("mirrorNode1---before = " + JsonUtil.toJson(node7));

        depth(node7);
//        System.out.println("mirrorNode1---after = " + JsonUtil.toJson(span));
    }

    public static void depth(Node root) {
        if (null == root)
            return;
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        Node current = null;
        while (!stack.isEmpty()) {
            current = stack.pop();
            System.out.print("current= " + current.getValue() + " ");
            if (current.left != null)
                stack.push(current.left);
            if (current.right != null)
                stack.push(current.right);
            System.out.println(" ");
        }
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

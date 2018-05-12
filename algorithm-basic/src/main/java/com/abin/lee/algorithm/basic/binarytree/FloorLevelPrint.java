package com.abin.lee.algorithm.basic.binarytree;

import com.abin.lee.algorithm.common.util.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by abin on 2018/5/11 21:33.
 * algorithm-test1
 * com.abin.lee.algorithm.basic.binarytree
 * http://blog.csdn.net/dlf123321/article/details/52435111
 * 关于二叉树的按层打印
 */
public class FloorLevelPrint {

    public static void main(String[] args) throws InterruptedException {
//        Node node1 = new Node(1);
//        Node node2 = new Node(2);
//        Node node3 = new Node(3, node1, node2);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6, node4, node5);
//        Node node7 = new Node(7, node6, node3);
        Node node7 = new Node(7, node6);
        System.out.println("mirrorNode1---before = " + JsonUtil.toJson(node7));

        floor(node7);
//        System.out.println("mirrorNode1---after = " + JsonUtil.toJson(span));
    }

    /**
     *               7
     *              /  \
     *             6    3
     *            / \   / \
     *           4   5 1   2
     * @param root
     * @throws InterruptedException
     */
    public static void floor(Node root) throws InterruptedException {
        if(null == root)
            return;
        BlockingQueue<Node> queue = new LinkedBlockingDeque<Node>();
        queue.offer(root) ;
        Node last = root;     //当前行的最后节点
        Node nextLast = root;   //下一行的最右节点
        while(!queue.isEmpty()){
            Node current = queue.take();
            System.out.print("current"+ current.getValue() + " ");
            if(current.left != null) {
                queue.put(current.left);
                nextLast = current.left ;
            }
            if(current.right != null) {
                queue.put(current.right);
                nextLast = current.right ;
            }
            if(current == last) {
                System.out.println(" ");
                last = nextLast ;
            }
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
        public Node(int value, Node left) {
            this.value = value;
            this.left = left;
        }
    }


}

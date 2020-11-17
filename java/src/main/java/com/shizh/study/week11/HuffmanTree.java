package com.shizh.study.week11;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName HuffmanTree
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/11/17
 **/
public class HuffmanTree {
    public static void main(String[] args) {
        int arr[] = {10, 20, 5, 15, 8, 2, 3,7,30
        };
        Node root = createHuffmanTree(arr);

        //测试一把
  preOrder(root);
    }

    //编写一个前序遍历的方法
    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("是空树，不能遍历~~");
        }
    }

    // 创建赫夫曼树的方法

    /**
     * @param arr 需要创建成哈夫曼树的数组
     * @return
     */
    public static Node createHuffmanTree(int[] arr) {
        // 第一步为了操作方便
        // 1. 遍历 arr 数组
        // 2. 将arr的每个元素构成成一个Node
        // 3. 将Node 放入到ArrayList中

        List<Node> list = new ArrayList<Node>();
        for (int value : arr) {
            list.add(new Node(value));

            while (list.size() > 1) {
                Collections.sort(list);
                //取
                Node leftNode = list.get(0);
                Node rightNode = list.get(1);
                //构建一个新的二叉树
                Node parentNode = new Node(leftNode.value + rightNode.value);
                parentNode.left = leftNode;
                parentNode.right = rightNode;
                //移除两个子节点
                list.remove(leftNode);
                list.remove(rightNode);
                //
                list.add(parentNode);

            }

        }
        return list.get(0);
    }

}

            //我们处理的过程是一个循环的过程


            // 创建结点类
// 为了让Node 对象持续排序Collections集合排序
// 让Node 实现Comparable接口
            class Node implements Comparable<Node> {
                int value; // 结点权值
                char c; //字符
                Node left; // 指向左子结点
                Node right; // 指向右子结点

                //写一个前序遍历
                public void preOrder() {
                    System.out.print(this.value+" ");
                    if (this.left != null) {
                        this.left.preOrder();
                    }
                    if (this.right != null) {
                        this.right.preOrder();
                    }
                }

                public Node(int value) {
                    this.value = value;
                }

                //@Override
                @Override
                public String toString() {
                    return "Node [value=" + value + "]";
                }

                //@Override
                @Override
                public int compareTo(Node o) {
                    // TODO Auto-generated method stub
                    // 表示从小到大排序
                    return this.value - o.value;
                }

            }


package com.jinshengcong.composite;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 * @date Created in 2021/03/06 16:35
 */
public class Main {
    public static void main(String[] args) {
        /* 根节点叫root */
        BranchNode root = new BranchNode("root");
        // 第一章
        BranchNode chapter1 = new BranchNode("chapter1");
        // 第二章
        BranchNode chapter2 = new BranchNode("chapter2");

        // 叶子节点
        Node c11  = new LeafNode("c11");
        Node c12  = new LeafNode("c12");

        // 分支节点 第二章的第一节
        BranchNode b21 = new BranchNode("section21");
        // 叶子节点
        Node c211 = new LeafNode("c211");
        Node c212 = new LeafNode("c212");

        // 在root下面有两个分支
        root.addNode(chapter1);
        root.addNode(chapter2);
        // root分支下面c1下又有c11.c12
        chapter1.addNode(c11);
        chapter1.addNode(c12);
        // root分支下面c2下又有section21
        chapter2.addNode(b21);

        //section21下又有 c211 和c212
        b21.addNode(c211);
        b21.addNode(c212);

        printTree(root,0);
    }

    /**
     * 打印这树 递归方式
     * @param root 根节点
     * @param depth 层次
     * @return void
     * @author 金聖聰
     * @email jinshengcong@163.com
     * @version v1.0
     * @date 2021/03/06 16:57
     */
    private static void printTree(Node root,int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("  |--");
        }
        // 先打印
        root.p();
        // 如果有分支节点
        if (root instanceof BranchNode){
            // 循环打印
            for (Node n : ((BranchNode) root).nodes) {
                printTree(n,depth+1);
            }
        }
    }

}
// 代表一个节点
abstract class Node {
    /**
     * 简单的打印出来
     *
     * @return void
     * @author 金聖聰
     * @email jinshengcong@163.com
     * @version v1.0
     * @date 2021/03/06 16:40
     */
    abstract public void p();
}

// 叶子节点
class LeafNode extends Node {
    /** 内容 */
    String content;

    public LeafNode(String content) {
        this.content = content;
    }

    @Override
    public void p() {
        System.out.println(content);
    }
}

// 分支节点
class BranchNode extends Node {
    /** 子节点 可以是叶子也可以是支 */
    List<Node> nodes = new ArrayList<>();
    String name ;

    public BranchNode(String name) {
        this.name = name;
    }

    @Override
    public void p() {
        System.out.println(name);
    }

    public void addNode(Node node){
        nodes.add(node);
    }
}
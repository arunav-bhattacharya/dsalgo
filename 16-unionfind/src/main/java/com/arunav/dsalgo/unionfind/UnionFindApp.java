package com.arunav.dsalgo.unionfind;

public class UnionFindApp {

    public static void main(String[] args) {
        UnionFind<Integer> unionFind = new UnionFind<>();
        addElements(unionFind);
        unionElements(unionFind);
        findElements(unionFind);
    }

    private static void findElements(UnionFind<Integer> unionFind) {
        System.out.println(unionFind.find(10));
        System.out.println(unionFind.find(20));
        System.out.println(unionFind.find(30));
        System.out.println(unionFind.find(40));
        System.out.println(unionFind.find(50));
        System.out.println(unionFind.find(60));
        System.out.println(unionFind.find(70));
        System.out.println(unionFind.find(80));
        System.out.println(unionFind.find(90));
        System.out.println(unionFind.find(100));
    }

    private static void unionElements(UnionFind<Integer> unionFind) {
        unionFind.union(10, 20);
        unionFind.union(20, 30);
        unionFind.union(40, 50);
        unionFind.union(60, 70);
        unionFind.union(50, 60);
        unionFind.union(30, 70);
        unionFind.union(80, 90);
        unionFind.union(100, 90);
    }

    private static void addElements(UnionFind<Integer> unionFind) {
        unionFind.add(10);
        unionFind.add(20);
        unionFind.add(30);
        unionFind.add(40);
        unionFind.add(50);
        unionFind.add(60);
        unionFind.add(70);
        unionFind.add(80);
        unionFind.add(90);
        unionFind.add(100);
    }
}

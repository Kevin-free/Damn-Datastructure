package com.kevin;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        /*int[] arr = new int[10];  静态数组
        for (int i=0;i<arr.length;i++){
            arr[i]=i;
        }
        int[] scores = new int[]{100,99,66};
        for (int i=0;i<scores.length;i++){
            System.out.println(scores[i]);
        }*/

        ArrayList arrayList = new ArrayList();

        Array<Integer> arr = new Array<>(); // 动态数组，即java提供的ArrayList
        for (int i = 0; i < 10; i++){
            arr.addLast(i);
        }
        System.out.println(arr); //调用toString方法
        System.out.println(arr.get(9));
        arr.set(9,100);
        arr.add(1,666);
        System.out.println(arr);

        arr.remove(1);
        System.out.println(arr);
        arr.remove(2);
        System.out.println(arr);

    }
}

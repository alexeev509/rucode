//package com.company;
//i use idea from here: https://github.com/rudenko-gold/rucode_2020_materials/blob/master/Div%20D/Day%201%20(Dynamic%20Programming)/E/main.cpp
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class E1 {
    private static int size;
    private static int[] mass;
    private static String[] a;

    public static void main(String[] args) throws IOException {
        enterInput(System.in);
        findIndexesElementsForRemoving();
    }


    public static void enterInput(InputStream in) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        size = Integer.parseInt(bf.readLine());
        a = bf.readLine().split(" ");
        mass = new int[size];
        for (int i = 0; i < size; i++) {
            mass[i] = Integer.parseInt(a[i]);
        }
    }

    private static void findIndexesElementsForRemoving() {

        boolean b=true;
        int count=1;
        for (int i = 1; i < size; i++) {
            if(mass[i]>mass[i-1] && b){
                b=false;
                count++;
            }else if(mass[i]<mass[i-1] && !b){
                b=true;
                count++;
            }
        }

        b=true;
        int count2=1;
        for (int i = 1; i < size; i++) {
            if(mass[i]<mass[i-1] && b){
                b=false;
                count2++;
            }else if(mass[i]>mass[i-1] && !b){
                b=true;
                count2++;
            }
        }
//        System.out.println(count);
//        System.out.println(count2);
        System.out.println(size-Math.max(count,count2));
    }
}

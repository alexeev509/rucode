//package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class A1 {

    static int[] mass;
    static int countOfElemenets;

    public static void main(String[] args) throws IOException {
        enterInput(System.in);
        findSequence();

    }

    private static void enterInput(InputStream inStream) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(inStream));
        countOfElemenets = Integer.parseInt(bf.readLine());
        String[] elements = bf.readLine().split(" ");
        mass=new int[countOfElemenets];
        for (int i = 0; i < mass.length; i++) {
            mass[i] = Integer.parseInt(elements[i]);
        }
    }
    public static void findSequence() {
        int[] d=new int[countOfElemenets];
        for (int i = 0; i < mass.length; i++) {
            d[i] = 1;
            for (int j = 0; j < i; j++) {
                if (mass[i]>mass[j] && d[j] + 1 > d[i]) {
                    d[i] = d[j] + 1;
                }
            }
        }
        findMax(d);
    }

    public static void findMax(int[] d){
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < d.length; i++) {
            if(d[i]>max){
                max=d[i];
            }
        }
        System.out.println(max);
    }
}

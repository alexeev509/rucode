//package com.company.firstDay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class G1 {

    private static int[] mass;
    private static int size;

    public static void main(String[] args) throws IOException {
        enterInput(System.in);
        findCount();
    }

    public static void enterInput(InputStream in) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        size = Integer.parseInt(bf.readLine());
        mass = new int[size];
        String[] str = bf.readLine().split(" ");
        for (int i = 0; i < size; i++) {
            mass[i] = Integer.parseInt(str[i]);
        }
    }

    private static void findCount() {
        int[] d=new int[size];
        int max=-1;
        for (int i = 0; i < mass.length; i++) {
            d[i] = 1;
            for (int j = 0; j < i; j++) {
                if (mass[i]>mass[j] && d[j] + 1 > d[i]) {
                    d[i] = d[j] + 1;
                }
            }
            max=Math.max(max,d[i]);
        }
//        System.out.println(Arrays.toString(d));
        System.out.println(mass.length-max);

    }

}


//6
//6 2 3 7 4 5

//7
//1 2 7 6 5 3 4

//3
//2 1 3

//4
//4 3 2 1

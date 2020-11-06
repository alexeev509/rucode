//package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class B1 {
    private static String str1;
    private static String str2;
    private static int mass[][];
    private static int columns;
    private static int rows;


    public static void main(String[] args) throws IOException {
        enterInput(System.in);
        findSequence();

    }

    private static void enterInput(InputStream in) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        str1 = bf.readLine();
        str2 = bf.readLine();
        //mb optimize
        rows = str1.length() + 1;
        columns = str2.length() + 1;
        //
        mass = new int[rows][columns];
    }

    private static void findSequence() {
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    mass[i][j] = mass[i - 1][j - 1]+1;
                } else {
                    mass[i][j]=Math.max(mass[i-1][j],mass[i][j-1]);
                }
            }
        }
//        printMass();
        getAnswer();
    }

    private static void getAnswer(){
        System.out.println(mass[rows-1][columns-1]);
        LinkedList<Integer> queue1=new LinkedList<>();
        LinkedList<Integer> queue2=new LinkedList<>();
        int i=rows-1;
        int j=columns-1;
        while (i>0 && j>0){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                queue1.add(i);
                queue2.add(j);
                i--;
                j--;
            }else {
                if(mass[i-1][j]>mass[i][j-1]){
                    i--;
                }else {
                    j--;
                }
            }
        }
        while (!queue1.isEmpty()){
            System.out.print(queue1.pollLast()+" ");
        }
        System.out.println();
        while (!queue2.isEmpty()){
            System.out.print(queue2.pollLast()+" ");
        }
    }

//    private static void printMass() {
//        for (int i = 0; i < mass.length; i++) {
//            System.out.println(Arrays.toString(mass[i]));
//        }
//    }


}

//package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class D1 {
    private static String str1;
    private static String str2;
    private static int[][] mass;
    private static int rows;
    private static int columns;


    public static void main(String[] args) throws IOException {
        enterInput(System.in);
        findDestinaton();

    }


    private static void enterInput(InputStream inStream) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(inStream));
        str1 = bf.readLine();
        str2 = bf.readLine();
        rows = str1.length()+1;
        columns = str2.length()+1;
        mass = new int[rows][columns];
    }

    private static void findDestinaton() {
        initializeMass(mass);
        System.out.println(getMinDistination());
    }


    public static void initializeMass(int[][] mass) {
        for (int i = 0; i < rows; i++) {
            mass[i][0] = i;
        }
        for (int j = 0; j < columns; j++) {
            mass[0][j] = j;
        }
    }

    public static int getMinDistination() {
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                int c = diff(str1.charAt(i - 1), str2.charAt(j - 1));
                mass[i][j] = Math.min(mass[i - 1][j] + 1, Math.min(mass[i][j - 1] + 1, mass[i - 1][j - 1] + c));
            }
        }
        return mass[rows - 1][columns - 1];
    }

    private static int diff(char c1, char c2) {
        if (c1 != c2) {
            return 1;
        }
        return 0;
    }
}

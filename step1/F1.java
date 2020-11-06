//package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class F1 {
    private static int N;
    private static int K;
    private static int T;
    private static Gangster[] gangsters;

    public static void main(String[] args) throws IOException {
        enterInput(System.in);
        findGangsters();
    }

    public static void enterInput(InputStream in) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        String[] str = bf.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        K = Integer.parseInt(str[1]);
        T = Integer.parseInt(str[2]);

        gangsters = new Gangster[N];

        str = bf.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            gangsters[i] = new Gangster();
            gangsters[i].setT(Integer.parseInt(str[i]));
        }

        str = bf.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            gangsters[i].setP(Integer.parseInt(str[i]));
        }

        str = bf.readLine().trim().split(" ");

        for (int i = 0,q=0; i < str.length; i++) {
            try {

                gangsters[q++].setS(Integer.parseInt((str[i])));

            } catch (Exception e) {

            }
        }


        Arrays.sort(gangsters, new Comparator<Gangster>() {
            @Override
            public int compare(Gangster o1, Gangster o2) {
                return Integer.compare(o1.getT(), o2.getT());
            }
        });


//        System.out.println(Arrays.toString(gangsters));

    }

    private static void findGangsters() {
        int[] d = new int[N + 1];
        Arrays.fill(d, -1);
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            //
            if (gangsters[i - 1].getT() >= gangsters[i - 1].getS()) {
                d[i] = gangsters[i - 1].getP();
            }
            //
            for (int j = 1; j < i; j++) {
                if (gangsters[i - 1].getT() - gangsters[j - 1].getT() >=
                        Math.abs(gangsters[i - 1].getS() - gangsters[j - 1].getS())
                        && d[j] != -1) {
                    d[i] = Math.max(d[i], d[j] + gangsters[i - 1].getP());
                }
            }
            answer = Math.max(answer, d[i]);
        }
//        System.out.println(Arrays.toString(d));
        System.out.println(answer);
    }


}

class Gangster {
    private int T;
    private int P;
    private int S;

    public int getT() {
        return T;
    }

    public void setT(int t) {
        T = t;
    }

    public int getP() {
        return P;
    }

    public void setP(int p) {
        P = p;
    }

    public int getS() {
        return S;
    }

    public void setS(int s) {
        S = s;
    }

    @Override
    public String toString() {
        return "Gangster{" +
                "T=" + T +
                ", P=" + P +
                ", S=" + S +
                '}';
    }
}
//3 10 20
//10 16 15
//10 11 10
//10 7 9

//2 10 20
//19 16
//10 11
//10 6

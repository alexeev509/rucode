import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class A {
    private static long[] a;
    private static int[] b;
    private static int a_size;
    private static int m;
    private static long x;
    private static long y;
    private static int z;
    private static int t;
    private static long[] summ;
    private static long finalSumm = 0;

    public static void main(String[] args) throws IOException {
        enterInput(System.in);
    }

    private static void enterInput(InputStream in) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        String[] s = bf.readLine().split(" ");
        a_size = Integer.parseInt(s[0]);
        x = Long.parseLong(s[1]);
        y = Long.parseLong(s[2]);
        a = new long[a_size];
        a[0] = Long.parseLong(s[3]);

        s = bf.readLine().split(" ");
        m = Integer.parseInt(s[0]);
        z = Integer.parseInt(s[1]);
        t = Integer.parseInt(s[2]);
        if (m != 0) {
            b = new int[m * 2];
            b[0] = Integer.parseInt(s[3]);
            generateSequenceA(a, x, y);
            generateSequenceB(b, z, t);
            for (int i = 0; i < m; i++) {
                finalSumm += getQueryAnswer(Math.max(b[2 * i], b[2 * i + 1]), Math.min(b[2 * i], b[2 * i + 1]));
            }
        }
        System.out.println(finalSumm);
    }

    private static void generateSequenceA(long[] arr, long x, long y) {
        summ = new long[a.length + 1];
        summ[0] = a[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = (arr[i - 1] * x + y);
            arr[i] &= 0xffff;
            summ[i] = summ[i - 1] + a[i];
        }


    }

    private static void generateSequenceB(int[] arr, int x, int y) {
        for (int i = 1; i < arr.length; i++) {
            arr[i] = (arr[i - 1] * x + y);
            arr[i] &= 0x3fff_ffff;
        }
        for (int i = 0; i < b.length; i++) {
            b[i] = b[i] % a.length;
        }
    }

//    public static void summQueries() {
//        summ = new long[a.length + 1];
//        summ[0] = a[0];
//        for (int i = 1; i < a.length; i++) {
//            summ[i] = summ[i - 1] + a[i];
//        }
//    }

    public static long getQueryAnswer(int e, int q) {
        if (q == 0)
            return summ[e];
        return summ[e] - summ[q - 1];
    }
}

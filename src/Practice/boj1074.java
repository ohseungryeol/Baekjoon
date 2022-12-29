package Practice;

import java.util.Scanner;

public class boj1074 {
    static int count=0;
    static int quad =0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int q =0;

        System.out.println(recursive(N,r,c,q));
    }

    public static int recursive(int N, int r, int c,int q) {
        int half = (int) (Math.pow(2, N - 1));

        if (half == 0) return q;

        if (r < half && c < half) {
            quad = 1;
        } else if (r < half && c >= half) {
            quad = 2;
            c = c-half;
        } else if (r >= half && c < half) {
            quad = 3;
            r= r-half;
        } else if (r >= half && c >= half) {
            quad = 4;
            r= r-half;
            c= c-half;
        }

        q += (half*half)*(quad-1);

        return recursive(N-1,r,c,q);
    }


}

package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class number{
    int x,y;
    number(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;


        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());
           // char[] ch = st.toString().toCharArray();
            int N = Integer.parseInt(st.nextToken());
            int digit = String.valueOf(N).length(); // 자릿수
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            StringBuilder sb = new StringBuilder();
            String max = "";

            while(max.length()<digit){
                if(x>y){
                    max+=String.valueOf(x);
                } else {
                    max+=String.valueOf(y);
                }
            }

            char[] ch = max.toCharArray();


        }
    }


    public static void makeBigNum(int N, int x, int y){
        String max = "";
        String xy = String.valueOf(x) + String.valueOf(y);
        String yx = String.valueOf(y)+ String.valueOf(x);
        int digit = String.valueOf(N).length(); // N의 자릿 수

        while(max.length()<digit){
            if(x>y){
                max+=String.valueOf(x);
            } else {
                max+=String.valueOf(y);
            }
        }

        char[] ch = max.toCharArray();
        int index =0;
        int num = Integer.parseInt(max);
        for (int i=0; i<ch.length; i++){
            if (num>N){
                ch[i]=Character.forDigit(Math.min(x,y),10);

            }
        }
    }
}
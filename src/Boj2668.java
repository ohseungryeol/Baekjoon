import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj2668 {
    static int N;
    static int[] arr1;
    static int[] arr2;
    static boolean[] check;
    static HashMap<Integer,int[]> map = new HashMap<>();
    static int max = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr1 = new int[N];
        arr2 = new int[N];


        // 윗줄 아랫줄 n개중에 r개를 뽑아서 일치하는 집합이 있는가 ?
        // 그 중 집합의 크기가 가장 큰 것을 뽑는다.

        for (int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            arr2[i]=num;
            arr1[i]=i+1;
        }


        for (int i=1; i<=N; i++){ // NC1 ~ NC2 -... NCN
            check = new boolean[N];
            int[] result = new int[i];
            int[] result2 = new int[i];
            combi_one(0,0,i,result,result2);
            // 0번행 조합
        }

        System.out.println(max);
        for(int num:map.get(max)) {
            System.out.println(num);
        }
    }


    // NC1 ~ NCN -> max값을 구해서 7개중에 7
    public static void combi_one(int L, int start, int len, int[] result, int[] result2){
        if(L==len){

            System.out.println("result1 = "+Arrays.toString(result));
            System.out.println("result2 = "+Arrays.toString(result2));
            int[] copy1 = result.clone();
            int[] copy2 = result2.clone();

            Arrays.sort(copy1);
            Arrays.sort(copy2);

            if(Arrays.equals(copy1,copy2)) {
                max = Math.max(max, len);
                map.put(len, copy1);
            }
            return;
        }

        for (int i=start; i<N; i++){
            if (!check[i]) {
                check[i] = true;
                result[L] = arr1[i];
                result2[L] = arr2[i];
                combi_one(L + 1, i+1, len, result,result2);
                check[i]=false;
            }
        }

    }

//    public static void combi_two(int L, int start, int len, int[] result,HashSet<int[]> set1){
//        if(L==len){
//            if(set1.contains(result)){
//
//            }
//            return;
//        }
//
//        for (int i=start; i<N; i++){
//            if(!check[i]){
//                check[i]=true;
//                result[L]=arr2[i];
//                combi_two(L+1,i,len,result);
//                check[i]=false;
//            }
//        }



}

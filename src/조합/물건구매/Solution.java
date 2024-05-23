package 조합.물건구매;

import java.util.Arrays;

public class Solution {
    static int answer = 0;

    public int solution(int N, int[] price, int k) {
        // Q : 서로 다른 2개의 물건을 구매하는 방법중 500원이 넘지 않는 경우의 수는 ?
        /*
        nC2
        i = 물건 번호
        */
        int[] arr = new int[k];
        boolean[] check = new boolean[price.length];
        DFS(0, 0, price, check, arr, k, 0);
        System.out.println(answer);
        return answer;
    }

    public static void DFS(int start, int L, int[] price, boolean[] check, int[] arr, int k, int sum) {
        if (L == arr.length) {

            System.out.println(Arrays.toString(arr));
            return;
        }

        // i를 0부터하면 순서가 바뀌어도 되는 permutaion , L부터하면 Combi(순서 고려)
        for (int i = start; i < price.length; i++) {
            arr[L] = i;
            DFS(i + 1, L + 1, price, check, arr, k, sum + price[L]);
        }
    }



    public static void main(String[] args) {
        Solution main = new Solution();
        main.solution(5, new int[]{100, 300, 400, 400, 200}, 2);
    }
}

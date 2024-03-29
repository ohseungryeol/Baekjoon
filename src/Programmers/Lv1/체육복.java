package Programmers.Lv1;

import java.util.Arrays;

public class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        // 빌려준 여부 체크 배열
        boolean[] check = new boolean[reserve.length];
        for (int i=0; i<lost.length; i++){
            for (int j=0; j<reserve.length; j++){
                if(lost[i]==reserve[j]){
                    lost[i]=0;
                    check[j]=true;
                    answer++;
                }
            }
        }
        for (int i=0; i<lost.length; i++){
            if(lost[i]==0) continue;
            for (int j=0; j<reserve.length; j++){
                if(!check[j] && Math.abs(lost[i]-reserve[j])==1){
                    check[j]=true;
                    answer++;
                    break;
                }

            }
        }

        System.out.println(answer);
        return answer;
    }
    public static void main(String[] args) {
        체육복 main = new 체육복();
        main.solution(5, new int[]{4,2}, new int[]{3,5});
    }
}

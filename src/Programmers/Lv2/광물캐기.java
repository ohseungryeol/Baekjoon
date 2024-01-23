package Programmers.Lv2;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class 광물캐기 {
    static int answer=0;
    static int seq=0;
    static String[] picka = {"diamond","iron","stone"};
    static int[][] pirodo = new int[][]{{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
    static HashMap<String, Integer> m = new HashMap<>();
    public int solution(int[] picks, String[] minerals) {


        m.put("diamond",0);
        m.put("iron",1);
        m.put("stone", 2);
        int dia=0;
        int iron=1;
        int stone=2;


        for (int i=0; i<picks.length; i++){
            int Pickax = picks[i]; //곡괭이 수 -> 다이아, 철, 돌 순
            //곡괭이를 다 소진했거나 광물을 다 캤거나 (종료조건)
            for (int j=seq; j< minerals.length; j++){

                j= Dig(Pickax,minerals,picks);
            }
        }

        System.out.println(answer);
        return answer;
    }

    public int Dig( int num, String[] minerals, int[] picks){ //곡괭이 수 , 곡괭이 종류 , 광물

        //광물의 종류마다 곡괭이를 변경
        for(int i=0; i<num; i++){
            if(seq>= minerals.length) break;
            seq+=5;
        }
        return 0;
    }


    /*
    * 각 곡괭이는 광물 5개를 캔 후에는 더 이상 사용 x
    1. 아무 곡괭이 선택해서 광물캠 (조합)
    2. 시작한 곡괭이로 사용할 수 없을 때까지 roop
    3. 주어진 순서대로 캔다
    4 곡괭이가 없거나 || 모든 광물을 캐거나
    * */
    public static void main(String[] args) {
        광물캐기 main = new 광물캐기();
        main.solution(new int[]{1, 3, 2}, new String[]{"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"});
    }
}

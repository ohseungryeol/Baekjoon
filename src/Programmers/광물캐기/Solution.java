package Programmers.광물캐기;

import java.util.*;

class Solution {
    //dia ,iron, stone 곡괭이 수
    static boolean[] check;
    static int answer = Integer.MAX_VALUE;
    static HashMap<String, Integer> map = new HashMap<>();
    static int[][] pirodo = new int[][]{{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};

    public int solution(int[] picks, String[] minerals) {

        map.put("diamond", 0);
        map.put("iron", 1);
        map.put("stone", 2);
        check = new boolean[minerals.length];
        /*
        각각 0~5개 가진다
        각 곡괭이는 총 5개까지만 캘 수 있음
        한번 사용 시작하면 해당 곡괭이는 사용할 수 없을 떄까지
        광물 순서대로 캐기
        loop: 곡괭이를 다쓰거나 모든 광물을 캐거나
        최소한의 피로도로
        - 돌을 캐는 것은 (돌곡괭이>철곡괭이>다이아곡괭이순)를 사용
        - 철을 캐는 것은 (철>다이야>돌) 순으로 캐자
        - 다이아를 캐는 것은 (다이아>철>돌)
        */

//         for (int i=0; i<minerals.length; i++){
//             if(check[i]) continue;

//             if(minerals[i].equals("diamond")){
//                 // 철 돌 돌 돌 돌
//                 if(picks)
//             } else if (minerals[i].equals("iron")){

//             } else {

//             }
//         }
        DFS(0, minerals, picks, 0);
        System.out.println(answer);
        return answer;
    }

    //곡괭이를 사용할 수 없을 때까지
    //
    // picks가 참조 값이라서 dfs 호출 끝나도 바뀌어버림.
    public static void DFS(int L, String[] minerals, int[] picks, int sum) {

        //종료조건: 광물을 다 캤거나, 곡괭이가 없거나

        if ((picks[0] == 0 && picks[1] == 0 && picks[2] == 0) || (L >= minerals.length)) {
            answer = Math.min(answer, sum);
            return;
        }


        //다이아 곡괭이
        int nextIdx = 0;
        if (picks[0] > 0) {
            for (int i = L; i < L + 5; i++) {
                if (i == minerals.length) break;
                sum += pirodo[0][map.get(minerals[i])];
                nextIdx = i;
            }
            L = nextIdx + 1;
            picks[0] -= 1;
            DFS(L, minerals, picks, sum);
            picks[0]+=1;
        }
        //철 곡괭이
        if (picks[1] > 0) {
            for (int i = L; i < L + 5; i++) {
                if (i == minerals.length) break;
                sum += pirodo[1][map.get(minerals[i])];
                nextIdx = i;
            }

            L = nextIdx + 1;
            picks[1] -= 1;
            DFS(L, minerals, picks, sum);
            picks[1]+=1;
        }
        //돌 곡괭이
        if (picks[2] > 0) {
            for (int i = L; i < L + 5; i++) {
                if (i == minerals.length) break;
                sum += pirodo[2][map.get(minerals[i])];
                nextIdx = i;
            }
            L = nextIdx + 1;
            picks[2] -= 1;
            DFS(L, minerals, picks, sum);
            picks[2]+=1;
        }
    }

    public static void main(String[] args) {
        Solution main = new Solution();
        main.solution(new int[]{2, 1, 0}, new String[]{"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "stone", "stone", "stone", "stone", "stone"});
    }
}

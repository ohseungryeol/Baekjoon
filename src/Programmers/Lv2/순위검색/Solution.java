package Programmers.Lv2.순위검색;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    static class Info{
        String Lang; //언어 cpp, java, python -
        String jop; // 직군 backend, front -
        String career; //경력 junior, senior -
        String soulFood; // chicken pizza -
        int score; // 1~100000

        public Info(String lang, String jop, String career, String soulFood, int score) {
            Lang = lang;
            this.jop = jop;
            this.career = career;
            this.soulFood = soulFood;
            this.score = score;
        }
    }
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        ArrayList<Info> arr = new ArrayList<>();


        for (String str:info){
            String[] tmp = str.split(" ");
            String lang = tmp[0];
            String jop = tmp[1];
            String career = tmp[2];
            String soulFood = tmp[3];
            int score = Integer.parseInt(tmp[4]);

            Info i = new Info(lang, jop, career, soulFood, score);
            arr.add(i);
        }

        int idx=0;
        for (String q:query){
            String[] tmp = q.split("and");
            String qLang = tmp[0];
            String qJop = tmp[1];
            String qCareer = tmp[2];
            String qSoulFoodAndScore = tmp[3];

            String[] s = qSoulFoodAndScore.split(" ");
            String qSoulFood = s[1];
            int qScore = Integer.parseInt(s[2]);
            int count=0;

            for (Info in: arr){
                String lang = in.Lang;
                String jop = in.jop;
                String career = in.career;
                String soulfood = in.soulFood;
                int score = in.score;
                // 쿼리 한개당 info는 몇명인가?
                if(equalsLang(lang,qLang) && equalsJob(jop,qJop) && equalsCareer(career,qCareer) && equalsSoulFood(soulfood,qSoulFood) && upScore(score,qScore)){
                    count++;
                }
            }

            answer[idx++]=count;

        }

        System.out.println(Arrays.toString(answer));
        //query 100000, info  50000 nlogn안에 해결

        return answer;
    }

    public static boolean equalsLang(String lang, String qLang){
        qLang = qLang.replaceAll(" ", "");
        return qLang.equals(lang) || qLang.equals("-");
    }
    public static boolean equalsJob(String job,String qJop){
        qJop = qJop.replaceAll(" ", "");
        return qJop.equals(job) || qJop.equals("-");
    }
    public static boolean equalsCareer(String career,String qCareer){
        qCareer=qCareer.replaceAll(" ", "");
        return qCareer.equals(career) || qCareer.equals("-");
    }
    public static boolean equalsSoulFood(String soulFood, String qSoulFood){
        qSoulFood = qSoulFood.replaceAll(" ", "");
        return qSoulFood.equals(soulFood) || qSoulFood.equals("-");
    }

    public static boolean upScore(int score, int qScore){
        return score>=qScore;
    }


    public static void main(String[] args) {
        Solution main = new Solution();
        main.solution(new String[]{"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"},
                new String[]{"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"});
    }
}

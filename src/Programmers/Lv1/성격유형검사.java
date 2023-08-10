package Programmers.Lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class 성격유형검사 {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        HashMap<Integer,Integer> choiceScore  = new HashMap<>();
        HashMap<Character,Integer> alphabetScore = new HashMap<>();
        int[] score = new int[8];
        score[1]=3;
        score[2]=2;
        score[3]=1;
        score[4]=0;
        score[5]=1;
        score[6]=2;
        score[7]=3;
        /*char[][] types = new char[4][4];

        types[0] = new char[]{'R', 'T'};
        types[1] = new char[]{'C', 'F'};
        types[2] = new char[]{'J', 'M'};
        types[3] = new char[]{'A', 'N'};*/


        ArrayList<char[]> type = new ArrayList<>();


        for (int i=0; i<survey.length; i++){
            String str = survey[i];
            char front = str.charAt(0);
            char back = str.charAt(1);

            int num = choices[i];

            /*num이 1~3이면 front, num이 5~7이면 back*/
            if(num<4){
                alphabetScore.put(front, alphabetScore.getOrDefault(front, 0) + score[num]);
            } else if (num>4){
                alphabetScore.put(back, alphabetScore.getOrDefault(back, 0) + score[num]);
            }
        }

        for(char key: alphabetScore.keySet()){
            System.out.println("key = " + key+", value="+alphabetScore.get(key));

        }

        if(alphabetScore.getOrDefault('R',0)> alphabetScore.getOrDefault('T',0)){
            answer += "R";
        } else if (alphabetScore.getOrDefault('R',0)< alphabetScore.getOrDefault('T',0)){
            answer +="T";
        } else {
            answer += compare("R", "T");
        }

        if(alphabetScore.getOrDefault('C',0)> alphabetScore.getOrDefault('F',0)){
            answer += "C";
        } else if (alphabetScore.getOrDefault('C',0)< alphabetScore.getOrDefault('F',0)){
            answer +="F";
        } else {
            answer += compare("C", "F");
        }

        if(alphabetScore.getOrDefault('J',0)> alphabetScore.getOrDefault('M',0)){
            answer += "J";
        } else if (alphabetScore.getOrDefault('J',0)< alphabetScore.getOrDefault('M',0)){
            answer +="M";
        } else {
            answer += compare("J", "M");
        }

        if(alphabetScore.getOrDefault('A',0)> alphabetScore.getOrDefault('N',0)){
            answer += "A";
        } else if (alphabetScore.getOrDefault('A',0)< alphabetScore.getOrDefault('N',0)){
            answer +="N";
        } else {
            answer += compare("A", "N");
        }
       // System.out.println(answer);
        return answer;
    }
    public static void main(String[] args) {
        성격유형검사 main = new 성격유형검사();
        main.solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5});
    }

    public String compare(String a, String b){
        if(a.compareTo(b)<0){
            return a;
        } else {
            return b;
        }
    }
}

package Programmers.Lv2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class 아날로그시계 {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;

        int hourOfSecond=0;
        int minuteOfSecond=0;

        int sec=s1-1;
        int minute=m1;
        int hour=h1;

        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        map.put(1,5); // hour = sec/5;
        map.put(2,10);
        map.put(3,15);
        map.put(4,20);
        map.put(5,25);
        map.put(6,30);
        map.put(7,35);
        map.put(8,40);
        map.put(9,45);
        map.put(10,50);
        map.put(11,55);
        while(true){


            sec++;
            if(hour==h2 && minute==m2 && sec==s2) break;

            if(sec==minute){
                minuteOfSecond++;
            }
            if(map.get(hour)==sec){
          //      System.out.printf("%d시 %d분 %d초\n",hour,minute,sec);
                hourOfSecond++;
            }
            if(map.get(hour)==sec && sec==minute){ //시 분 초 다 같음
                minuteOfSecond-=1;
                hourOfSecond-=1;
                answer++;
            }

            if(sec==60){
                sec=-1;
                minute++;
                if(minute==60) minute=0;
            }
            if(minute==60){
                minute=0;
                hour++;
                if(hour==12) hour=0;
            }



        }
        System.out.println(minuteOfSecond+","+hourOfSecond);
        System.out.println(answer+minuteOfSecond+hourOfSecond);

        return answer;
    }
    public static void main(String[] args) {
        아날로그시계 main = new 아날로그시계();
        main.solution(0,	0,	0,	23,	59,	59);
    }
}

package Programmers;

import java.util.ArrayList;
import java.util.HashMap;
class 유효기간 {
    public ArrayList<Integer> solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        ArrayList<Integer> arr = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        int tAllday = getDate(today);

        for (String tmp: terms){
            String[] t = tmp.split(" ");
            map.put(t[0],Integer.parseInt(t[1]));
        }
        for (int i=0; i<privacies.length; i++){
            String[] p = privacies[i].split(" ");
            int pday = getDate(p[0]);
            int pAllday = (map.get(p[1])*28)+pday-1;
            if(pAllday<tAllday){
                //answer[i]=i+1;
                arr.add(i+1);
            }
        }
        return arr;

        //모든 달은 28일까지

    }

    public int getDate(String today){
        int year = Integer.parseInt(today.substring(0, 4));
        //System.out.println(year);
        int month = Integer.parseInt(today.substring(5, 7));
        //System.out.println(year);
        int day = Integer.parseInt(today.substring(8));


        return (year*12*28)+(month*28)+day;
    }

    public static void main(String[] args) {

    }
}
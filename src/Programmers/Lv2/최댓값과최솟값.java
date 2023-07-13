package Programmers.Lv2;

public class 최댓값과최솟값 {
    public static void main(String[] args) {
        최댓값과최솟값 a = new 최댓값과최솟값();
        System.out.println( a.solution("1 -2 3 -4 100 -1000"));
    }

    public String solution(String s) {
        String answer = "";
        String[] str = s.split(" ");

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (String tmp: str){
            int num = Integer.parseInt(tmp);
            if(num<min) min = num;
            if(num>max) max = num;
        }

        answer = min+" "+max;
        return answer;


    }
}

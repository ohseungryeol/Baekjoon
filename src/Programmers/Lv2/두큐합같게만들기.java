package Programmers.Lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 두큐합같게만들기 {
    static Queue<Integer> q1 = new LinkedList<>();
    static Queue<Integer> q2 = new LinkedList<>();

    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        int sum1=0;
        int sum2=0;
        int totalSum=0;
        for (int i = 0; i < queue1.length; i++){
            q1.offer(queue1[i]);
            totalSum+=queue1[i]+queue2[i];
            q2.offer(queue2[i]);
        }

        if(totalSum%2==1){
            return -1;
        } else {
            //짝수면 같게 만들 수 있음 로직
        }
        return 0;
    }
    public static void main(String[] args) {
        두큐합같게만들기 main = new 두큐합같게만들기();
        main.solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1});
    }
}

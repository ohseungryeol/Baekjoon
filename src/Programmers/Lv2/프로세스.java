package Programmers.Lv2;

import java.util.*;

public class 프로세스 {
    static class Process{
        int num;
        int score;

        public Process(int num, int score) {
            this.num = num;
            this.score = score;
        }
    }
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Process> queue = new LinkedList<>();
        ArrayList<Integer> arr =new ArrayList<>();
        for (int i=0; i< priorities.length; i++){
            queue.add(new Process(i, priorities[i]));
            arr.add(priorities[i]);
        }
        //System.out.println(Collections.max(arr));
        /*
        1. 실행 대기 큐(Queue)에서 대기중인 프로세스 하나를 꺼냅니다.
        2. 큐에 대기중인 프로세스 중 우선순위가 더 높은 프로세스가 있다면 방금 꺼낸 프로세스를 다시 큐에 넣습니다.
        3. 만약 그런 프로세스가 없다면 방금 꺼낸 프로세스를 실행합니다.
            3.1 한 번 실행한 프로세스는 다시 큐에 넣지 않고 그대로 종료됩니다.
        * */

        while(true){
            Process tmp = queue.poll();
            if(tmp.score==Collections.max(arr)){ //
                answer++; //실행
                arr.remove(Integer.valueOf(tmp.score));
                if(tmp.num==location) break;

            } else { //더 큰것이 있음 .
                queue.offer(tmp); //다시 큐에넣는다.
            }
        }

        //TODO location에 위치한 프로세스는 몇번째로 실행되는가 ?
        return answer;
    }

    public static void main(String[] args) {
        프로세스 프로세스 = new 프로세스();
        System.out.println(프로세스.solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }
}

package Programmers;

import java.util.*;

public class LectureProgress {
    static ArrayList<time> arr = new ArrayList<>();
    static class Remain{
        String lecture;
        int remainTime;

        public Remain(String lecture, int remainTime) {
            this.lecture = lecture;
            this.remainTime = remainTime;
        }
    }
    static class time implements Comparable<time> {
        String lecture;
        int start,playtime;

        public time(String lecture,int start, int playtime) {
            this.lecture=lecture;
            this.start = start;
            this.playtime = playtime;
        }

        @Override
        public int compareTo(time o) {
            return this.start-o.start;
        }
    }
    public static void main(String[] args) {
        String[][] plans = {{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}};
        System.out.println(Arrays.toString(solution(plans)));
    }
/*plans의 원소는 [name, start, playtime]
* 과목은 시작 시간 순으로 시작
* 과제 진행중에 새로운 과제가 시작할 시간이 되면 진행중 과목 정지
* 끝남과 동시에 새로운 과목 시작
* 멈춘 과목이 여러개면 먼저 멈춘 순으로 다시 진행
* 끝낸 순으로 출력 */
    public static String[] solution(String[][] plans) {
        Stack<Remain> stack = new Stack<>();
      //  Stack<String> stack = new Stack<>();
        String[] answer = new String[plans.length];
        int idx=0;
        for (String[] plan:plans){
           String lecture = plan[0];
           int start = getMinutes(plan[1]);
           int playtime = Integer.parseInt(plan[2]);
            arr.add(new time(lecture, start, playtime));
        }

        Collections.sort(arr);

         //780
        String prevLec = "";
        int prevTime =0;
        for (int i=0; i<arr.size(); i++){
            while(!stack.isEmpty()){
                Remain prev = stack.pop();
                int endTime = prevTime+prev.remainTime; //780
                if(arr.get(i).start<endTime){ //진행중 과제가 끝나기 전에 새로운 과제가 시작 -> 진행한 시간만큼 남은시간 차감후 다시 push
                    stack.push(new Remain(prev.lecture,endTime-arr.get(i).start));
                    break;
                } else { // 진행중 과제를 종료 후 진행한 시간만큼 prevTime에 추가 후 갱신
                    answer[idx++]=prev.lecture;
                    prevTime += prev.remainTime;
                }
            }

            stack.push(new Remain(arr.get(i).lecture,arr.get(i).playtime));
            prevTime = arr.get(i).start; //전 과목 시작 시간

        }
        // System.out.println(stack.pop().lecture);
        //System.out.println(stack.pop().lecture);
        while(!stack.isEmpty()){
            System.out.println(answer[idx]=stack.pop().lecture);
            idx++;
        }
        return answer;
    }



    public static int getMinutes(String time){
        String[] tmp = time.split((":"));
        int hour = Integer.parseInt(tmp[0]);
        int minute= Integer.parseInt(tmp[1]);

        return hour*60+minute;

    }
}

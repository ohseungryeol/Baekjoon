package Simulation;
import java.util.*;

public class boj1713 {
    static class Student implements Comparable<Student>{
        int num;
        int seq;
        int cnt;
        public Student(int num, int seq, int cnt) {
            this.num = num;
            this.seq = seq;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Student o) {
            if(this.cnt==o.cnt){
                return this.seq-o.seq;
            }

            return this.cnt-o.cnt;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //사진 틀의 갯수
        int R = sc.nextInt(); //총 추천 횟수
        int[] recommend = new int[101];
        int[] answer = new int[N];
        ArrayList<Student> students= new ArrayList<>();
        boolean flag;

        int seq=1;
        int idx=0;
        for (int i=0; i<R; i++){
            flag = true;
            int stuNum = sc.nextInt();

            for (Student s:students){ //현재 액자에 이미 게시되어 있는 경우라면 추천 수만 증가하고 continue
                if(stuNum==s.num){
                    s.cnt++;
                    flag =false;
                }
            }

            if(flag==false) continue;
            recommend[stuNum]++;

            if(idx<N){
                answer[idx++]=stuNum;
                students.add(new Student(stuNum,seq++,recommend[stuNum]));
            } else { //액자가 꽉 차있다면 현재 액자에서 추천 순 순서 순 오름차순 정렬 후 삭제 -> 삭제 후 새로운 사진 추가
                Collections.sort(students);
                Student delStu = students.get(0);
                for (int j=0; j<N; j++){
                    if(answer[j]==delStu.num){
                        answer[j]=stuNum;
                    }
                }
                recommend[delStu.num]=0;
                students.remove(0);
                students.add(new Student(stuNum,seq++,recommend[stuNum]));
            }
        }

        Arrays.sort(answer);

        for (int i=0; i<answer.length; i++){
            if(answer[i]==0) continue;
            System.out.print(answer[i]+" ");
        }
    }
}
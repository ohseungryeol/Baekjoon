import java.util.Scanner;

public class boj14501 {
    static int MAX=0; //이익 최대값
    static int N;
    static int[] Pi;
    static int[] Ti;
    int answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         N = sc.nextInt(); //상담할 수있는 기간
         Pi = new int[N + 1]; //상담 수익
         Ti = new int[N + 1]; // 상담에 소요되는 일 수
        for (int i=1; i<=N; i++){
            Ti[i] = sc.nextInt();
            Pi[i] = sc.nextInt();
        }
        DFS(1,0);
        System.out.println(MAX);
    }

    public static void DFS(int index, int earn){
         MAX = Math.max(MAX, earn); //원래 최대값과 새롭게 들어온 이익 비교
        if (index==N+1) return; //N+1번쨰 되는 날 종료
        //상담을 할때
        if(index+Ti[index]<=N+1){ //현재가 N일이고 상담소요기간이 1일이어도 상담가능. 7+1 =8
            DFS(index+Ti[index],earn+Pi[index]);
        }
        //안할떄 이익은 그대로
        DFS(index + 1, earn);

    }


}

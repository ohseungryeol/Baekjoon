import java.util.Scanner;

public class boj1018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        char[][] chess = new char[N][M];
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < M; j++) {
                chess[i][j] = s.charAt(j);
            }
        }
        int answer = 0;

        for (int i=0; i<N; i++){
            for (int j=0; j<M-1; j++){
                if(chess[i][j]=='W'){ //현재가 화이트면
                    if(nextWhite(chess[i][j+1])){
                        answer++;
                        chess[i][j+1] ='B';
                    }
                } else{ //현재가 블랙이면
                    if(nextBlack(chess[i][j+1])){
                        answer++;
                        chess[i][j+1] ='W';
                    }
                }
            }
        }

        System.out.println(answer);
    }

    public static boolean nextWhite(char a){
        if (a=='W'){ //a가 흰색이면
            return true;
        }
        return false;
    }

    public static boolean nextBlack(char a){
        if (a=='B'){ //a가 흰색이면
            return true;
        }
        return false;
    }
}

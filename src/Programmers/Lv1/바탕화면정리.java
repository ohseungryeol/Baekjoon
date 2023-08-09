package Programmers.Lv1;

public class 바탕화면정리 {
    static int R,C;
    public int[] solution(String[] wallpaper) {
        R = wallpaper.length;
        C = wallpaper[0].length();
        int ldx = Integer.MAX_VALUE;
        int ldy = Integer.MAX_VALUE;
        int rdx = Integer.MIN_VALUE;
        int rdy = Integer.MIN_VALUE;
        char[][] screen = new char[R][C];
        int[] answer = new int[4];

        for (int i=0; i<R; i++){
            String tmp = wallpaper[i];
            for (int j=0; j<C; j++){
                screen[i][j] = tmp.charAt(j);
                if (screen[i][j] == '#') {
                    ldx = Math.min(ldx,i); // 가장 위의 # //
                    ldy = Math.min(ldy,j); //가장 왼쪽 #
                    rdx = Math.max(rdx,i); // 가장 아래쪽 #
                    rdy = Math.max(rdy,j); // 가장 오른쪽 #
                }
            }
        }

        answer[0]=ldx;
        answer[1]=ldy;
        answer[2]=rdx+1;
        answer[3]=rdy+1;
        System.out.println("answer[0] = " + answer[0]+","+answer[1]+","+answer[2]+","+answer[3]);
        return answer;
    }

    public static void main(String[] args) {
        바탕화면정리 main = new 바탕화면정리();
        main.solution(new String[]{".#...", "..#..", "...#."});
    }
}

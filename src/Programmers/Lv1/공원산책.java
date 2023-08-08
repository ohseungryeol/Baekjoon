package Programmers.Lv1;

import java.util.StringTokenizer;

public class 공원산책 {
    static int R,C;
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int x=0;
        int y=0;
        R = park.length;
        C = park[0].length();

        char[][] map = new char[R][C];
        for (int i=0; i< R; i++){
            String tmp = park[i];
            for (int j=0; j<C; j++){
                map[i][j]=tmp.charAt(j);
                if(map[i][j]=='S'){
                    answer[0]=i;
                    answer[1]=j;
                }
            }
        }

        for (int i=0; i<routes.length; i++){
            StringTokenizer st = new StringTokenizer(routes[i]);
            String direction = st.nextToken();
            int go = Integer.parseInt(st.nextToken());
            int nx = answer[0];
            int ny = answer[1];
            boolean flag=false;
            switch (direction){
                case "E":
                    for (int g=1; g<=go; g++){
                        if(isRange(nx,ny+1) && map[nx][ny+1]!='X'){
                            ny = ny+1;
                        } else{
                            //명령을 아예 수행하지 않음
                            flag=true;
                        }
                    }
                    if(!flag) answer[1]=ny;
                    else flag = false;
                    break;
                case "S":

                    for (int g=1; g<=go; g++){
                        if(isRange(nx+1,ny) && map[nx+1][ny]!='X'){
                            nx = nx+1;
                        } else{
                            flag = true;
                        }
                    }

                    if(!flag) answer[0]=nx;
                    else flag = false;
                    break;
                case "W":
                    for (int g=1; g<=go; g++){
                        if(isRange(nx,ny-1) && map[nx][ny-1]!='X'){
                            ny=ny-1;
                        } else {
                            flag = true;
                        }
                    }
                    if(!flag) answer[1]=ny;
                    else flag = false;
                    break;
                case "N":
                    for (int g=1; g<=go; g++){
                        if(isRange(nx-1,ny) && map[nx-1][ny]!='X'){
                            nx=nx-1;
                        } else {
                            flag = true;
                        }
                    }
                    if(!flag) answer[0]=nx;
                    else flag = false;
                    break;
            }
        }
       // System.out.println(answer[0]+","+answer[1]);
        return answer;
    }

    public boolean isRange(int nx, int ny){
        if(nx>=0 && nx<R && ny>=0 && ny<C) return true;

        return false;
    }

    public static void main(String[] args) {
        공원산책 main = new 공원산책();
        main.solution(new String[]{"SOO","OOO","OOO"}, new String[]{"E 2","S 2","W 1"});
    }
}

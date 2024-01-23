package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2503 {
    static int answer =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] info = new String[N];

        for (int i=0; i<N; i++){
            String str = br.readLine();
            info[i]=str;
        }
        combi("",info);
        System.out.println(answer);

    }

    public static void combi(String num, String[] infos){
        if(num.length()==3){
            if(isAnswer(num,infos)) answer++;
            return;
        }
        for (int i=1; i<=9; i++){
            String s = String.valueOf(i);
            if(num.contains(s)) continue;
            combi(num+s,infos);
        }
    }

    public static boolean isAnswer(String answerNum, String[] infos){
        for(String info: infos){
            String[] str = info.split(" ");
            String sayNum = str[0];
            int strikeCnt = Integer.parseInt(str[1]);
            int ballCnt = Integer.parseInt(str[2]);
            int s=0;
            int b=0;
            for (int i=0; i<sayNum.length(); i++){
                if(sayNum.charAt(i)==answerNum.charAt(i)) s++;
                else if(answerNum.contains(String.valueOf(sayNum.charAt(i)))) b++;
            }

            if(strikeCnt!=s || ballCnt!=b) return false;
        }

        return true;
    }
}

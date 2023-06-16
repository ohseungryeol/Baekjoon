package Programmers;

import java.util.Scanner;

public class 다트게임 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //System.out.println(Math.pow(2,3));
        다트게임 dart = new 다트게임();
        System.out.println(dart.solution(sc.next()));
    }

    //TODO: S,D,T -> ^1 , ^2 , ^3
    // * ->  해당점수와 이전점수 2배효과
    //TODO: # ->  해당 점수 *-1
    public int solution(String dartResult){

        int[] dart = new int[3];
        int idx=0;
        for(int i=0; i<dartResult.length(); i++){ //TODO: 점수|보너스|옵션  -> 숫자가 나올 떄마다 dart[idx++]
           char c = dartResult.charAt(i);
           if(i>0 && c=='0' && dartResult.charAt(i-1)=='1') continue;
           if(isOption(c)){ //Option
               if(c=='*'){
                   if(idx-1>0) {
                       dart[idx - 2] *= 2;
                       dart[idx-1]*=2;
                   } else {
                       dart[idx-1] *=2;
                   }
               } else { //#
                   dart[idx-1]*=-1;
               } // 1S*2S*3S
           } else if (isBonus(c)){ //S D T
               if(c=='S'){
                   dart[idx-1]= dart[idx-1]*1;
               } else if (c=='D'){
                   dart[idx-1] = dart[idx-1]*dart[idx-1];
               } else {
                   dart[idx-1]= dart[idx-1]*dart[idx-1]*dart[idx-1];
               }
           } else {  //숫자

               if(c=='1' && dartResult.charAt(i+1)=='0'){
                   dart[idx++] = 10;
               } else {
                   dart[idx++] = Integer.parseInt(String.valueOf(c));
               }
           }
        }

        return dart[0]+dart[1]+dart[2];
    }

    public boolean isOption(char c){
        if(c=='*' || c=='#') return true;
        return false;
    }
    public boolean isBonus(char c){
        if(c=='S' || c=='T' || c=='D') return true;
        return false;
    }

}

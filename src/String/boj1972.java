package String;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class boj1972 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            String str =sc.next();
            if(str.equals("*")){
                break;
            }

            if(!isSurprise(str)){
                System.out.printf("%s is NOT surprising.\n",str);
            } else {
                System.out.printf("%s is surprising.\n",str);
            }
        }
    }

    /*
    * D=거리
    * 모든 D- 쌍들이 유일하면 return true
    * 0- 쌍부터 (N-2)쌍 까지 존재 . 0쌍 -> 거리가 1
    * ZGBG -> 0쌍: ZG,GB,BG | 1쌍: ZB, GG | 2쌍 ZG
    * */
    public static boolean isSurprise(String str){


        int N = str.length();
        if(N==1) return true;
        for (int i=0; i<N-2; i++){
            int d =i+1;
            Map<String,Integer> map = new HashMap<>();
            for (int j=0; j+d<N; j++){
                String tmp="";
                tmp+=str.charAt(j);
                tmp+=str.charAt(j+d);
               // String tmp = String.valueOf(str.charAt(j)+str.charAt(j+d));
                map.put(tmp,map.getOrDefault(tmp,0)+1);
            }

            for (String tmp:map.keySet()){
                if(map.get(tmp)>1) return false;
            }
        }
        return true;
    }
}

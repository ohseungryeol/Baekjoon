package Programmers;

import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;
import java.util.Arrays;

public class 비밀지도 {
    public static void main(String[] args) {
        비밀지도 비밀지도 = new 비밀지도();
        int n =5; //열 크기
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        System.out.println(Arrays.toString(비밀지도.solution(5,arr1,arr2)));
    }

    public String[] solution(int n, int[] arr1, int[] arr2) { //#=1 , 공백 =0 (이진수)
        String[] answer = new String[n];


        for (int i=0; i<n; i++){
            String binary1=Integer.toBinaryString(arr1[i]); // 1001
            String binary2=Integer.toBinaryString(arr2[i]); //11110
            int diff1 = n-binary1.length();
            int diff2 = n-binary2.length();
            while(diff1-->0){
                binary1="0"+binary1;
            }
            while(diff2-->0){
                binary2="0"+binary2;
            }
            System.out.println("================");
            System.out.println(binary1);
            System.out.println(binary2);
            String str = "";
            for (int j=0; j<n; j++){
                if(binary1.charAt(j)=='1' || binary2.charAt(j)=='1'){
                    str+='#';
                } else{
                    str+=' ';
                }
            }
            answer[i]=str;
        }
        return answer;
    }
}

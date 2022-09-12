import java.util.*;

import static java.lang.Integer.parseInt;

public class boj1755 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<String> arr = new ArrayList<>();
        for (int i=n; i<=m; i++){
            String answer = "";
            String str = Integer.toString(i);
            char[] ch = str.toCharArray(); // 8

            for (int j=0; j<ch.length; j++){
                int i1 = ch[j] - '0'; // char을 int로 변환
                answer +=numToString(i1)+" ";
            }
            arr.add(answer);
        }

        Collections.sort(arr); //정렬
        int[] answer = new int[arr.size()]; //정답 담을 배열


        for (int i=0; i<arr.size(); i++){
            int i2=0;
            String num ="";
            String str = arr.get(i);

            String[] str2 = str.split(" "); //공백 기준 쪼깸(2자리숫자)

            if (str2.length>1){ //2자리 숫자이면
                num+=stringToInt(str2[0]);
                num += stringToInt(str2[1]);
                i2 = parseInt(num);
            } else { // 1자리 숫자이면
                i2 = stringToInt(str2[0]);
            }

            answer[i] = i2;
        }

        int size = answer.length;
        int count=1;
        int i=0;

        while(true){ //정답 출력문
            System.out.print(answer[i]+" ");
            i++;
            if(count%10 ==0 ) System.out.println();
            if(count==answer.length) break;
            count++;
        }

    }



    public static String numToString(int i){
        switch(i){
            case 0: return "zero";
            case 1: return "one";
            case 2: return "two";
            case 3: return "three";
            case 4: return "four";
            case 5: return "five";
            case 6: return "six";
            case 7: return "seven";
            case 8: return "eight";
            case 9: return "nine";
            default: return " ";
        }
    }

    public static int stringToInt(String s){

        switch(s){
            case "zero": return 0;
            case "one": return 1;
            case "two": return 2;
            case "three": return 3;
            case "four": return 4;
            case "five": return 5;
            case "six": return 6;
            case "seven": return 7;
            case "eight": return 8;
            case "nine": return 9;
            default: return -1;
        }
    }
}


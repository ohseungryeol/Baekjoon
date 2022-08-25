import java.util.Scanner;

public class wordNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strArr = str.split(" ");

        int wordNum = strArr.length;

        if (strArr.length == 0) { //만약 아무것도 입력하지 않았다면 배열의 크기가 0이므로 배열[0] 이런식으로 접근하면 에러가 뜨므로 아예 0을 프린트 해주고 프로그램을 종료합니다.
            System.out.println(0);
            System.exit(0); //프로그램 강제 종료
        }

        if(strArr[0].isBlank()){
            System.out.println(wordNum-1);
        } else{
            System.out.println(wordNum);
        }


    }
}

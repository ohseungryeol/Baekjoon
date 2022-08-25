import java.util.Scanner;

public class CheckGroupWord1316 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count=0;
        for (int i=0; i<n; i++){
            String str = sc.next();
            if(isGroupString(str)){
                count++;
            }
        }

        System.out.println(count);
    }

    public static boolean isGroupString(String str){
        boolean[] check = new boolean[26];

        for (int i=0; i<str.length(); i++){
            char tmp = str.charAt(i);
            if(check[tmp-'a']){
                return false;
            } else{
                if (i<str.length()-1 && tmp!=str.charAt(i+1)){
                    check[tmp-'a']=true;
                }
            }
        }
        return true;
    }


}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj3568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String[] vars = str.split(", ");

        // 변수 형식을 고려하여 CommonVar 추출
        String[] firstVarParts = vars[0].split(" ");
        String CommonVar = firstVarParts[0];

        // 배열 길이 확인 추가
        for (int i = 0; i < firstVarParts.length; i++) {
            if (firstVarParts[i].equals("")) {
                CommonVar = firstVarParts[i + 1];
                break;
            }
        }

        vars[0] = vars[0].replace(CommonVar, "").replaceAll(" ", "");
        vars[vars.length - 1] = vars[vars.length - 1].replaceAll(";", "");

        // StringBuilder 사용
        for (String var : vars) {
            String varName = "";
            String reverse = "";
            for(int i=0; i<var.length(); i++){
                if(!Character.isAlphabetic(var.charAt(i))){
                   // varName = var.substring(0,i);
                    StringBuilder tmp = new StringBuilder(var.substring(i,var.length()));
                    reverse = tmp.reverse().toString();
                    break;
                }else{
                    varName+=var.charAt(i);
                }
            }

            String newTmp = CommonVar+reverse+" "+varName+";";
            newTmp = newTmp.replace("][", "[]");
            System.out.println(newTmp);
        }
    }
}
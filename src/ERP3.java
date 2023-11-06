import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ERP3 {
   /* Deeper neural networks are more difficult to train. We present a residual learning framework to ease the training of networks that are substantiallydeeper than those used previously.[ some_paper_a, some_paper_b ] We explicitly  reformulate the layers as learning residual functions with reference to the layer inputs, instead of learning unreferenced functions.[ some_book_a, some_paper_a ] We provide comprehensive empirical evidence showing that these residual networks are easier to optimize, and can gain accuracy from considerably increased depth. [ some_book_b ]

    Deeper neural networks are more difficult to train. We present a residual
    learning framework to ease the training of networks that are substantially
    deeper than those used previously.[ 1, 2 ] We explicitly
    reformulate the layers as learning residual functions with reference to the layer
        inputs, instead of learning unreferenced functions.[ 1, 3 ]
    We provide comprehensive empirical evidence showing that these residual networks are
    easier to optimize, and can gain accuracy from considerably increased depth. [ 4 ]*/
    /*
    [1] some_paper_a
    [2] some_paper_b
    [3] some_book_a
    [4] some_book_b
    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        //문헌의 제목은 쉼표로 구분
        // [ 제목, 제목, 제목 ] 띄어쓰기제목쉼표 띄어쓰기제목쉼표
                        //->  띄어쓰기숫자쉼표 띄어쓰기숫자쉼표
        int start=0;
        int end =0;
        int sequence=1;
        boolean flag = false;
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<input.length(); i++){

            if(input.charAt(i)=='['){
                start = i;
            } else if (input.charAt(i)==']'){
                end =i;
                flag = true;
            }

            if(flag){
                String literature = input.substring(start+1,end);
                literature = literature.replace("[","");
                literature = literature.replace("]","");
                String[] str = literature.split(",");
                for (int j=0; j<str.length; j++){
                    str[j]=str[j].replaceAll(" ","");
                    if(!map.containsKey(str[j])) {
                        map.put(str[j], sequence++);
                    }
                }

                flag = false;
            }
        }
        String answer = "";
        int s =0;
        int e =0;
        for (int i=0; i<input.length(); i++){
            answer+=input.charAt(0);
            if(input.charAt(i)=='['){
                s = i;
            } else if (input.charAt(i)==']'){
                e =i;
                flag = true;
            }

            if(flag){
                String literature = input.substring(start+1,end);
                if(input.contains(literature)){
                    input.replace(literature, String.valueOf(map.get(literature)));
                }
            }
        }

        System.out.println(input);



        //참조 목록 출력

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(Map.Entry.comparingByValue());
        for(Map.Entry<String, Integer> entry : entryList){
            if(input.contains(entry.getKey())){
                input = input.replace("ss",entry.getKey());
            }
            System.out.printf("[%d] %s\n",entry.getValue(),entry.getKey());
        }


    }
}


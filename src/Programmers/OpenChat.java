package Programmers;

import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public String[] solution(String[] record) {
        ArrayList<String> print = new ArrayList<>();
        HashMap<String, String> Map = new HashMap<>();


        for (int i=0; i<record.length; i++){
            String[] str =record[i].split(" ");

            if(str[0]=="Enter"){
                Map.put(str[1],str[2]);
                print.add(str[1]+"님이 들어왔습니다.");
            } else if (str[0]=="Change"){
                Map.put(str[1],str[2]);
            } else{
                print.add(str[1]+"님이 나갔습니다.");
            }
        }

        String[] answer = new String[print.size()];
        for (int i=0; i<print.size(); i++){
            String tmp= print.get(i);
            int index = tmp.indexOf("님");
            String id = tmp.substring(0,index);
            answer[i]=Map.get(id)+print.get(i).substring(index);
                    }

        return answer;
    }
}

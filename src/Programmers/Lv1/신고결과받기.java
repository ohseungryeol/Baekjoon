package Programmers.Lv1;

import java.util.*;

public class 신고결과받기 {

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String,Integer> reportedMap = new HashMap<>();
        HashMap<String, HashSet<String>> reportInfo = new HashMap<>();
        HashMap<String,Integer> indexMap = new HashMap<>();
        Set<String> stopUser = new HashSet<>();
        //ArrayList<String> stopUser = new ArrayList<>();

        for (int i=0; i<id_list.length; i++){
            indexMap.put(id_list[i],i);
            reportInfo.put(id_list[i],new HashSet<>());
        }

        for (int i=0; i<report.length; i++){
            boolean reportedFlag = false;
            String tmp = report[i];
            String[] rep = tmp.split(" ");

            String reporter = rep[0]; //신고자
            String reported = rep[1]; // 신고 당한자
            if(reportInfo.containsKey(reporter) && reportInfo.get(reporter).contains(reported)){
                continue;
            }
            reportInfo.get(reporter).add(reported);
            reportedMap.put(reported, reportedMap.getOrDefault(reported, 0) + 1);

        }

        for (String key: reportedMap.keySet()){

            if(reportedMap.get(key)>=k){
                stopUser.add(key);
            }
        }

        for (String reporter: reportInfo.keySet()){
            HashSet<String> reportedPersons = reportInfo.get(reporter);

            Iterator<String> it = reportedPersons.iterator();
            while(it.hasNext()) {
                String s = it.next();
                if(stopUser.contains(s)){
                    answer[indexMap.get(reporter)]++;
                }
            }
        }

        for(int i=0; i<answer.length; i++){
            System.out.println(answer[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        신고결과받기 main = new 신고결과받기();
        //main.solution(new String[]{"con", "ryan"}, new String[]{"ryan con", "ryan con", "ryan con", "ryan con"},3);
        main.solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"},2);
    }
}

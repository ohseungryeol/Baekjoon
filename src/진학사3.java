import java.util.*;

public class 진학사3 {
    public ArrayList<String> solution(String[] orders) {
        ArrayList<String> answer = new ArrayList<>();
        HashMap<String, HashSet<String>> map = new HashMap<>();
        HashMap<String, Integer> answerMap = new HashMap<>();

        for (String order: orders){
            String[] info = order.split(" ");
            String user = info[0];
            if(!map.containsKey(user)) map.put(user, new HashSet<String>());
            for (int i=1; i<info.length; i++){
                map.get(user).add(info[i]);
            }
        }

        for(String key:map.keySet()){
            Integer foodCount = map.get(key).size();
            answerMap.put(key,foodCount);
        }

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(answerMap.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });


        int maxFoodCount = 0;
        for (int i=0; i<entryList.size(); i++){
            if(i==0){
                answer.add(entryList.get(i).getKey());
                maxFoodCount = entryList.get(i).getValue();
            } else{
                if(maxFoodCount==entryList.get(i).getValue()) answer.add(entryList.get(i).getKey());
            }
        }

        Collections.sort(answer);

        return answer;
    }
    public static void main(String[] args) {
        진학사3 main = new 진학사3();
        main.solution(new String[]{"alex pizza pasta", "alex pizza pizza", "alex noodle", "bob pasta", "bob noodle sandwich pasta", "bob steak noodle"});
    }
}

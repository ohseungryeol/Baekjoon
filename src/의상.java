import java.util.HashMap;

public class 의상 {
    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> map = new HashMap<>();
        for(String[] kinds: clothes){
            String name = kinds[0];
            String kind = kinds[1];
            map.put(kind,map.getOrDefault(kind,0)+1);
        }
        int sum=0;
        int mul=1;

        for (String key:map.keySet()){
            sum+=map.get(key);
            if(map.size()>1){
                mul*=map.get(key);
            } else {
                mul=0;
            }

        }
        //
        answer = sum+mul;
        return answer;
    }

    public static void main(String[] args) {
        의상 main = new 의상();
        main.solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}});
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ERP2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Character> stack = new Stack<>();
        Map<Character, Integer> openMap = new HashMap<>();
        Map<Character, Integer> closeMap = new HashMap<>();
        for (int i=0; i<input.length(); i++){
            Character c = input.charAt(i);
            if(c=='(' || c=='[' || c=='{') openMap.put(c, openMap.getOrDefault(c, 0) + 1);
            if(c==')' || c==']' || c=='}') closeMap.put(c, closeMap.getOrDefault(c, 0) + 1);
        }

        if(openMap.get('(')==closeMap.get(')')
            && openMap.get('[')==closeMap.get(']')
            && openMap.get('{')==closeMap.get('}')){
            System.out.println("True");
        } else {
            System.out.println("False");
        }

    }
}

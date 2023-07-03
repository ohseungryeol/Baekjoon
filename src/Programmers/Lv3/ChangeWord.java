package Programmers.Lv3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ChangeWord {
    static boolean[] visited;
    static int[] dis;

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words= {"hot", "dot", "dog", "lot", "log", "cog"};
        ChangeWord changeWord = new ChangeWord();
        System.out.println(changeWord.solution(begin, target, words));

        /*
        * 한번에 한 개의 알파벳씩만 바꾸면서 단어를 변환
        * words에 있는 단어로만!
        * 최소 몇번의 과정으로 begin을 target으로 만들 수 있을까?
        * */
    }
    public int solution(String begin, String target, String[] words) { //최소 변환의 수 리턴
        int answer = 0;
        visited = new boolean[words.length];
        dis = new int[words.length];
        Queue<Integer> queue = new LinkedList<>();
        // words배열을 ArrayList로 변환 후 안에 target이 존재하지 않으면 변환불가
        if(!Arrays.asList(words).contains(target)) return 0;

        for (int i=0; i<words.length; i++){
            if(isSimilar(begin,words[i])){
                queue.offer(i); //변환 가능한 단어 idx를 큐에 넣는다.
                dis[i]=1;
                visited[i]=true;
            }
        }

        while(!queue.isEmpty()){
            int curIdx = queue.poll();
            if(words[curIdx].equals(target)){
                answer = dis[curIdx];
                break;
            }

            for (int next=0; next<words.length; next++){
                // 아직 방문하지 않았고 변환 가능한 단어라면
                if(!visited[next] && isSimilar(words[curIdx],words[next])){
                    queue.offer(next);
                    dis[next]=dis[curIdx]+1;
                    visited[next]=true;

                    if(words[next].equals(target)){ //다음 방문이 target이라면 answer에 저장
                        answer = dis[next];
                    }
                }
            }
        }


        return answer;
    }

    public boolean isSimilar(String begin, String next){ //모든 단어의 길이는 같음
        int cnt =0;
        for (int i=0; i<begin.length(); i++){
            if(begin.charAt(i)==next.charAt(i)){
                cnt++;
            }
        }
        if(cnt==begin.length()-1){
            return true;
        }
        return false;
    }

}

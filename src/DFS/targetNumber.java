package DFS;

public class targetNumber {
    static int[] numbers = {4,1,2,1};
    static int target =4;
    static int answer =0;
    public static void main(String[] args) {
        DFS(0,0,0);
        System.out.println(answer);
    }

    public static void DFS(int num,int sum,int index){
        System.out.println("D("+num+","+sum+","+index+")");
        sum+=num;
        if(index==numbers.length){
            if(sum==target){

                answer++;
            }
            return;
        }

        for (int i=index; i<numbers.length; i++){
            DFS(numbers[i],sum,index+1);
            DFS(-numbers[i],sum,index+1);
        }
    }
}

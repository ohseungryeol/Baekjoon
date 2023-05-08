public class 박스 {
    public static void main(String[] args) {
        int[] boxes = {1000,800,900};
        int m =1000000;
        int k=3;


        for(int i=0; i<k; i++){
            int max = 0;
            for(int j=0; j<boxes.length; j++){
                int earnMax = m/10000*boxes[j];
                if(earnMax>100000) continue;
                if(max<earnMax){
                    max = earnMax;
                }

            }
            if(max!=0) m+=max;
        }

        System.out.println(m);
    }
}

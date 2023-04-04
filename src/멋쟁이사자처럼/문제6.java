package 멋쟁이사자처럼;

public class 문제6 {
    static class Stack {
        int top;    //인덱스
        int size;    //스택 배열의 크기
        int [] stack;

        public Stack(){
            stack = new int[10000];
            top=-1;
        }
        public Stack(int size) {
            this.size = size;
            stack = new int[size];
            top = -1;
        }

        public void push(int item) {
            stack[++top] = item;
        }

        public int pop() {
            int pop = stack[top];
            stack[top--]=0;
            return pop;
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5000);
        stack.push(10);
        System.out.println(stack.pop());
    }
}

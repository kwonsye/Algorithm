import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class StackSequence1874 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Stack<Integer> stack = new Stack<>();
        List<String> results = new ArrayList<>();

        int maxNum = scanner.nextInt();

        int input=1;
        for(int i=0; i<maxNum; i++){
            int num = scanner.nextInt();

            if(!stack.isEmpty() && stack.peek()>num){
                System.out.println("NO");
                return;
            }

            for(;input<=num; input++){
                stack.push(input);
                results.add("+");
            }

            if(!stack.isEmpty() && stack.peek()==num){
                stack.pop();
                results.add("-");
            }
        }

        results.stream().forEachOrdered(System.out::println);
    }
}

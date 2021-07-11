import java.util.*;

public class PrinterQueue1966 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Document> queue = new LinkedList();
        Queue<Integer> sortedQueue = new PriorityQueue(Collections.reverseOrder());
        List<Integer> results = new ArrayList<>();
        int count = 0;

        int testCaseCount = scanner.nextInt();
        for(int i=0; i<testCaseCount; i++){
            int documentCount = scanner.nextInt();
            int target = scanner.nextInt();

            for(int j=0; j<documentCount; j++){
                int priority = scanner.nextInt();
                Document document = new Document(j==target ? true : false, priority);

                queue.add(document);
                sortedQueue.add(priority);
            }

            while(!queue.isEmpty()){
                Document document = queue.poll();

                if(document.priority < sortedQueue.peek()){
                    queue.add(document);
                    continue;
                }

                if(document.priority == sortedQueue.peek()){
                    if(document.isTarget) {
                        results.add(++count);
                        count=0;
                        queue.clear();
                        sortedQueue.clear();
                        break;
                    }

                    count++;
                    sortedQueue.poll();
                }
            }
        }

        results.stream().forEachOrdered(System.out::println);
    }

    static class Document {
        boolean isTarget;
        int priority;

        Document(boolean isTarget, int priority){
            this.isTarget = isTarget;
            this.priority = priority;
        }
    }
}

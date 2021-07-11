import java.util.Scanner;

public class BlackJack2798 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cardsNum = scanner.nextInt();
        int targetSum = scanner.nextInt();
        int[] cards = new int[cardsNum];
        int result = 0;

        for(int i = 0; i < cardsNum; i++){
            cards[i] = scanner.nextInt();
        }

        for(int i = 0; i < cardsNum - 2; i++){
            for(int j = i+1; j < cardsNum -1; j++){
                for(int k = j+1; k < cardsNum; k++){
                    int sum = cards[i] + cards[j] + cards[k];
                    if(sum <= targetSum){
                        result = Math.max(result, sum);
                    }
                }
            }
        }

        System.out.println(result);
    }
}

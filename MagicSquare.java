package pck1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MagicSquare {
/*HackerRank 
 * Forming a Magic Square*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] s = new int[3][3];

		for (int row = 0; row < s.length; row++) {
			for (int col = 0; col < s[0].length; col++) {
				s[row][col] = sc.nextInt();
			}
		}
		
		System.out.println(formingMagicSquare(s));

		sc.close();
	}

	// Complete the formingMagicSquare function below.
	static int formingMagicSquare(int[][] s) {
		int[][][] possibleMagicSquare = { { { 8, 1, 6 }, { 3, 5, 7 }, { 4, 9, 2 } },
				{ { 6, 1, 8 }, { 7, 5, 3 }, { 2, 9, 4 } }, { { 4, 9, 2 }, { 3, 5, 7 }, { 8, 1, 6 } },
				{ { 2, 9, 4 }, { 7, 5, 3 }, { 6, 1, 8 } }, { { 4, 3, 8 }, { 9, 5, 1 }, { 2, 7, 6 } },
				{ { 2, 7, 6 }, { 9, 5, 1 }, { 4, 3, 8 } }, { { 8, 3, 4 }, { 1, 5, 9 }, { 6, 7, 2 } },
				{ { 6, 7, 2 }, { 1, 5, 9 }, { 8, 3, 4 } } };

		//int[] costs = new int[8];
		List<Integer> costsList=new ArrayList<>();
		for (int arrayCount = 0; arrayCount < possibleMagicSquare.length; arrayCount++) {
			int cost = 0;
			for (int row = 0; row < s.length; row++) {
				for (int col = 0; col < s[0].length; col++) {
					//비용계산
					cost += Math.abs(possibleMagicSquare[arrayCount][row][col] - s[row][col]);
				}
			}
			costsList.add(cost);
		}
		
		//costsList중에서 가장 작은 값 가져오기
		//오름차순
		Collections.sort(costsList);
		//비용중에 가장 작은값을 리턴해준다.
		return costsList.get(0);
	}
}

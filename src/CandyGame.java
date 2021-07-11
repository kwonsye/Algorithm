import java.util.Scanner;
//Brute-force
//백준 #3085
public class CandyGame {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt();
		char[][] array = new char[N][N];
		//입력받기
		for(int row=0; row<N; row++) {
			String rowStr = scanner.next();
			for(int col=0; col<N; col++) {
				array[row][col] = rowStr.charAt(col);
			}
		}
		
		char[][] switchedArray = new char[N][N];
		valueCopy(array,switchedArray);
		
		int globalmax=0;
		
		//가로인접행렬끼리 switch
		for(int row=0; row<N; row++) {
			for(int col=0; col<N-1; col++) {
				switching(switchedArray, row, col, row, col+1);
				//max사탕개수 구하기
				int localmax = countMaxCandy(switchedArray);
				globalmax = Math.max(globalmax, localmax);
				//원상복귀
				valueCopy(array,switchedArray);
			}
		}
		
		scanner.close();
	}
	
	public static int countMaxCandy(char[][] arr) {
		int horizenMax=0, verticalMax = 0;
		//수평방향에서 max값 찾기
		int count=1;
		for(int row=0; row<arr.length; row++) {
			for(int col=0; col<arr[0].length-1; col++) {
				if(arr[row][col] == arr[row][col+1]) {
					count++;
				} else {
					
				}
			}
		}
		return 0;
	}
	
	public static void switching(char[][] arr, int fromRow, int fromCol, int toRow, int toCol) {
		char temp = arr[toRow][toCol];
		arr[toRow][toCol] = arr[fromRow][fromCol];
		arr[fromRow][fromCol] = temp;
	}
	
	public static void valueCopy(char[][] from, char[][] to) {
		// 값 복사
		for (int row = 0; row < from.length; row++) {
			for (int col = 0; col < from.length; col++) {
				to[row][col] = from[row][col];
			}
		}
	}
	
	public static void printArray(char[][] arr) {
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[0].length; col++) {
				System.out.print(arr[row][col]);
			}
			System.out.println("");
			
		}
	}
}

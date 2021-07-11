import java.util.Scanner;
import java.util.Vector;
//dfs
public class Cabbage {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		
		Vector<Integer> testcaseWorms = new Vector<Integer>(testcase);
		
		for(int test=0; test<testcase; test++) {
			int M = sc.nextInt();
			int N = sc.nextInt();
			int[][] arr = new int[M][N];
			
			//�ʱ�ȭ
			for(int row=0; row<M; row++) {
				for(int col=0; col<N; col++) {
					arr[row][col] = 0;
				}
			}
			
			int K = sc.nextInt();
			for(int k=0; k<K; k++) {
				int m = sc.nextInt();
				int n = sc.nextInt();
				arr[m][n] = 1;
			}
			
			testcaseWorms.add(findAllWarms(arr));
		}
			
		sc.close();
		
		for(int worms : testcaseWorms) {
			System.out.println(worms);
		}
	}
	
	static int findAllWarms(int[][] arr) {
		
		int components = 0;
		
		for(int row = 0; row < arr.length; row++) {
			for(int col = 0; col < arr[0].length; col++) {
				//is not visited
				if(arr[row][col] == 1) {
					findWarms(arr,row,col);
					components++;
				}
			}
		}
		
		return components;
	}
	
	//dfs
	static void findWarms(int[][] arr, int row, int col) {
		arr[row][col] = 0; //visit
		
		//������ Ž�� //�ñ��� : JVM�� &&���� ������ false�϶� �������� �˻����� �ʰ� �׳� �ѱ��? -> �׷���.
		if((col+1)!=arr[0].length && arr[row][col+1] == 1) {
			findWarms(arr,row,col+1);
		}
		//���� Ž��
		if(col!=0 && arr[row][col-1] == 1) {
			findWarms(arr,row,col-1);
		}
		//���� Ž��
		if(row!=0 && arr[row-1][col] == 1) {
			findWarms(arr,row-1,col);
		}
		//�Ʒ��� Ž��
		if((row+1)!=arr.length && arr[row+1][col] == 1) {
			findWarms(arr,row+1,col);
		}
	}

}

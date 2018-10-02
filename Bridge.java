package pck1;

import java.util.Scanner;

public class Bridge {
/*1004 다리놓기*/
	public static void main(String[] args) {
		//(N,M)의 가능한 경우의수가 저장되어 있는 이차원배열
		int[][] bridge=new int[30][30];
		
		//N=1일떄 가능한 경우의 수는 M과 같다
		for(int M=1;M<30;M++)
			bridge[1][M]=M;
		//베열에 모든 경우의 수를 미리 계산해서 저장=>재귀를 줄이는 방법으로 사용가능!
		for(int N=2;N<30;N++) {
			for(int M=N;M<30;M++) {
				for(int count=M-1;count>=(N-1);count--)
					bridge[N][M]+=bridge[N-1][count];
			}
		}
		
		Scanner sc=new Scanner(System.in);
		int caseCount=sc.nextInt();
		
		int N,M;
		int[] result=new int[caseCount];
		for(int count=0;count<caseCount;count++) {
			N=sc.nextInt();
			M=sc.nextInt();
			//계산을 미리해놓은 배열에서 경우의수를 가져온다
			result[count]=bridge[N][M];
		}
		//결과 출력
		for(int resultCount=0;resultCount<caseCount;resultCount++){
			System.out.println(result[resultCount]);
		}
		
		sc.close();
	}

}

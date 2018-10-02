package pck1;

import java.util.Scanner;

public class Bridge {
/*1004 �ٸ�����*/
	public static void main(String[] args) {
		//(N,M)�� ������ ����Ǽ��� ����Ǿ� �ִ� �������迭
		int[][] bridge=new int[30][30];
		
		//N=1�ϋ� ������ ����� ���� M�� ����
		for(int M=1;M<30;M++)
			bridge[1][M]=M;
		//������ ��� ����� ���� �̸� ����ؼ� ����=>��͸� ���̴� ������� ��밡��!
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
			//����� �̸��س��� �迭���� ����Ǽ��� �����´�
			result[count]=bridge[N][M];
		}
		//��� ���
		for(int resultCount=0;resultCount<caseCount;resultCount++){
			System.out.println(result[resultCount]);
		}
		
		sc.close();
	}

}

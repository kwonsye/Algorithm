package pck1;

import java.util.Scanner;
/*���� �˰��� 1052 ����*/
public class Bottle {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int beforeBottleCount=sc.nextInt();
		//�� �ʿ��� �������� ���� ���� ����
		int afterBottleCount=beforeBottleCount;
		int limit=sc.nextInt();
		
		while(true) {
			int oneCount=0;//������������ 1�� ������ �������� ������ִ� ���� ��
			//������ ���ڿ��� ����
			String binaryString=Integer.toBinaryString(afterBottleCount);
			
			//������ ���ڿ����� 1�� ����ã��
			for(int i=0;i<binaryString.length();i++) {
				if(binaryString.charAt(i)=='1')
					oneCount++;
			}
			
			if(oneCount<=limit)
				break;
			else if(oneCount>limit)//���������� �� �ٿ����Ѵٸ� ���Կ��� 1L ��;��Ѵ�.
				afterBottleCount++;
		}
		
		//break�� ������ ã�����̱� ������ ��� �������� �����ָ� ��
		System.out.println(afterBottleCount-beforeBottleCount);
		
		sc.close();
	}

}
	


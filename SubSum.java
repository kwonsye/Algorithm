package pck1;

import java.util.Scanner;
//Brute-force
//���� #2231
public class SubSum {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();

		int subsum = 0;
		for (int correctNum = 1; correctNum < num; correctNum++) {
			subsum = calSubSum(correctNum); //�κ��� ���
			if(correctNum/10 != 0) {
				subsum += correctNum; //���� �ڸ��� �ƴ϶�� �ڱ� �ڽŵ� ���ϱ�
			}
			
			if(subsum == num) {
				System.out.println(correctNum);
				break;
			}
			
			if(correctNum == num-1) {
				System.out.println(0);
			}
		}

		scanner.close();

	}
	
	public static int calSubSum(int number) {
		
		int subsum = 0;
		int target = 0;
		int divide = 1;
		while (true) {
			target = number / divide;
			if (target == 0) {
				break;
			}
			subsum += (target % 10);
			divide *= 10;
		}
		
		return subsum;
	}
	

}

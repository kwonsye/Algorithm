package pck1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChickenCoupon {
/*1673 ġŲ����*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		List<Integer> list=new ArrayList<Integer>();
		while (sc.hasNextInt()) {

			int haveCouponCount = sc.nextInt();
			int stampsForOneCoupon = sc.nextInt();

			int totalChickenCount = 0;
			int totalStampCount = 0;

			while (haveCouponCount > 0 || (totalStampCount >= stampsForOneCoupon)) {

				totalChickenCount += haveCouponCount;

				totalStampCount += haveCouponCount;
				// ������ �ٛ����Ƿ� 0��
				haveCouponCount = totalStampCount / stampsForOneCoupon;
				totalStampCount %= stampsForOneCoupon;

			}
			// ���೻���������ִ������� 0���̰� ������
			// �������ιٲܼ����� ������
			list.add(totalChickenCount);

		}
		
		for(int totalChickenCount:list) {
			System.out.println(totalChickenCount);
		}
	}

}

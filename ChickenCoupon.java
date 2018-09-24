package pck1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChickenCoupon {
/*1673 치킨쿠폰*/
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
				// 쿠폰은 다썻으므로 0개
				haveCouponCount = totalStampCount / stampsForOneCoupon;
				totalStampCount %= stampsForOneCoupon;

			}
			// 만약내가가지고있는쿠폰이 0개이고 도장이
			// 쿠폰으로바꿀수없는 개수면
			list.add(totalChickenCount);

		}
		
		for(int totalChickenCount:list) {
			System.out.println(totalChickenCount);
		}
	}

}

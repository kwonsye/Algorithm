package pck1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
//Brute-Force
//백준 #2309
public class SevenDwarves {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int[] dwarvesHeight = new int[9]; //0~8
		
		//난쟁이 키 입력받기
		for(int dwarfCount=0; dwarfCount<dwarvesHeight.length; dwarfCount++) {
			dwarvesHeight[dwarfCount] = scanner.nextInt();
		}
		
		int heightSum = 0;
		for(int height : dwarvesHeight) {
			heightSum += height; //난쟁이 9명의 키 합
		}
		
		int fakeHeights = 0; //가짜 난쟁이 2명의 키 합
		if(heightSum > 100) {
			fakeHeights = heightSum-100;
		} else {
			System.out.println("Wrong Heights Input");
		}
		
		//가짜 난쟁이 두 명 찾기
		int fakeDwarf1 = 0, fakeDwarf2 = 0;
		
		for(int stdFakeDwarf=0; stdFakeDwarf<dwarvesHeight.length-1; stdFakeDwarf++) {
			int targetHeight = fakeHeights-dwarvesHeight[stdFakeDwarf];
			for(int targetFakeDwarf = stdFakeDwarf+1; targetFakeDwarf<dwarvesHeight.length; targetFakeDwarf++) {
				if(targetHeight == dwarvesHeight[targetFakeDwarf]) {
					fakeDwarf1 = dwarvesHeight[stdFakeDwarf];
					fakeDwarf2 = dwarvesHeight[targetFakeDwarf];
					break;
				}
			}
		}
		
		//진짜 난쟁이 출력
		Arrays.sort(dwarvesHeight); //오름차순 정렬
		for(int height : dwarvesHeight) {
			if(height!=fakeDwarf1 && height!=fakeDwarf2) {
				System.out.println(height);
			}
		}
		
		scanner.close();
	}

}

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
//Brute-Force
//���� #2309
public class SevenDwarves {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int[] dwarvesHeight = new int[9]; //0~8
		
		//������ Ű �Է¹ޱ�
		for(int dwarfCount=0; dwarfCount<dwarvesHeight.length; dwarfCount++) {
			dwarvesHeight[dwarfCount] = scanner.nextInt();
		}
		
		int heightSum = 0;
		for(int height : dwarvesHeight) {
			heightSum += height; //������ 9���� Ű ��
		}
		
		int fakeHeights = 0; //��¥ ������ 2���� Ű ��
		if(heightSum > 100) {
			fakeHeights = heightSum-100;
		} else {
			System.out.println("Wrong Heights Input");
		}
		
		//��¥ ������ �� �� ã��
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
		
		//��¥ ������ ���
		Arrays.sort(dwarvesHeight); //�������� ����
		for(int height : dwarvesHeight) {
			if(height!=fakeDwarf1 && height!=fakeDwarf2) {
				System.out.println(height);
			}
		}
		
		scanner.close();
	}

}

package MashUpStudy;

import java.util.Arrays;
/* �ڵ���Ƽ Lesson5_1 ���� ��� 
 * 1���õ� 90% - Integer.MAX_VALUE ����������� : �� �������� �������� �𸣰ھ��µ� �����÷� �� �ɷ� ���..
 * https://app.codility.com/demo/results/trainingEPTAGC-ZGR/
 * 
 * 2���õ� 100%
 * https://app.codility.com/demo/results/trainingBRX478-35A/
 * */
public class PassingCars {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{0,1,0,1,1})); //expected 5
	}

	public static int solution(int[] A) {
		int eastCarCount = 0; // zero count
		int westCarCount = 0; // one count
		int totalPassingCarCount = 0;
		
		//���������� �˸��� ���� �迭 ũ�⸦ 1 �ø���, 0�� �� �ڿ� �߰��������
		int[] zeroAddedArr = Arrays.copyOf(A, A.length+1);
		
		for(int arrIndex=0; arrIndex<zeroAddedArr.length; arrIndex++) {
			if(zeroAddedArr[arrIndex] == 0) {
				totalPassingCarCount += (eastCarCount * westCarCount);
				if(totalPassingCarCount>1000000000 || totalPassingCarCount<0) {
					return -1;
				}
				eastCarCount++;
				westCarCount = 0;
			} else { // zeroAddedArr[arrIndex] == 1
				westCarCount++;
			}
		}
		
		return totalPassingCarCount;
	}
}

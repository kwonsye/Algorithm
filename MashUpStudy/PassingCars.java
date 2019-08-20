package pck1.MashUpStudy;

import java.util.Arrays;
/* 코딜리티 Lesson5_1 실행 결과 
 * 1차시도 90% - Integer.MAX_VALUE 고려안했을때 : 왜 음수값이 나오는지 모르겠었는데 오버플로 난 걸로 결론..
 * https://app.codility.com/demo/results/trainingEPTAGC-ZGR/
 * 
 * 2차시도 100%
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
		
		//마지막임을 알리기 위해 배열 크기를 1 늘리고, 0을 맨 뒤에 추가해줘야함
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

package pck1.MashUpStudy;

import java.util.HashSet;
import java.util.Set;

/* 코딜리티 Lesson4_2 실행 결과 
 * TimeComplexity : O(N)
 * https://app.codility.com/demo/results/training2TFY9N-NR6/
*/
public class FrogRiverOne {

	public static void main(String[] args) {
		System.out.println(solution(5, new int[]{1,3,1,4,2,3,5,4}));
	}
	public static int solution(int X, int[] A) {
		//중복 위치의 나뭇잎은 제외하기 위해 해시셋 이용
		Set<Integer> leavesPosition = new HashSet<>();
		
		for(int arrIndex = 0; arrIndex < A.length; arrIndex++) {
			//목적지 보다 가까운 위치에 떨어지는 것만 생각한다.
			if(A[arrIndex] <= X) leavesPosition.add(A[arrIndex]);
			//개구리가 목적지까지 갈 수 있는 경우
			if(leavesPosition.size() == X) return arrIndex;
		}
		return -1;
	}
}

package pck1.MashUpStudy;

import java.util.HashSet;
import java.util.Set;

public class OddOccurrencesInArray {

	public static void main(String[] args) {
		int[] A = {9,3,9,3,9,7,9,7,9};
		
		System.out.println(solution(A));
	}
	
	public static int solution(int[] A) {
		Set<Integer> oddCheckSet = new HashSet<>();
		
		for(int arrIndex=0; arrIndex<A.length; arrIndex++) {
			if(oddCheckSet.contains(A[arrIndex])) {
				oddCheckSet.remove(A[arrIndex]);
			} else {
				//해시셋에 없으면 추가
				oddCheckSet.add(A[arrIndex]);
			}
		}
		
		return oddCheckSet.iterator().next();
	}

}

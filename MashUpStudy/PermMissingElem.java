package pck1.MashUpStudy;
/* 코딜리티 Lesson3_2 실행 결과
 * 1)sort 이용
 * https://app.codility.com/demo/results/training5KFH5N-VFT/
 * 
 * 2)array이용
 * https://app.codility.com/demo/results/trainingA9PRTU-BV7/
 * 
*/
public class PermMissingElem {

	public static void main(String[] args) {
		
		int[] A = {2,3,1,5};
		System.out.println(solution(A));
	}

	public static int solution(int[] A) {
	
		/* 
		 * 1)정렬 이용
		Arrays.sort(A);
		for(int arrIndex=0; arrIndex<A.length; arrIndex++) {
			if(A[arrIndex]-arrIndex != 1) {
				return arrIndex+1;
			}
		}
		
		return A.length+1; //for 문 안걸렸다면 마지막 원소가 없다는 뜻
		*/
		
		// 2)배열 이용
		boolean[] isExist = new boolean[A.length+2];// false : 나온 적 없음, true : 나온 적 있음
		//배열 초기화
		for(int arrIndex=0; arrIndex<isExist.length; arrIndex++) {
			isExist[arrIndex] = false;
		}
		
		//나온거 체크
		for(int arrIndex=0; arrIndex<A.length; arrIndex++) {
			isExist[A[arrIndex]] = true;
		}
		
		//false 원소의 index 리턴
		for(int arrIndex=1; arrIndex<isExist.length; arrIndex++) {
			if(!isExist[arrIndex]) {
				return arrIndex;
			}
		}
		return -1;
	}
}

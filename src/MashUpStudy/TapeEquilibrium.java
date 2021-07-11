package MashUpStudy;
/* �ڵ���Ƽ Lesson3_3 ���� ���
 * https://app.codility.com/demo/results/trainingD9B2CK-9Y3/
*/	
public class TapeEquilibrium {

	public static void main(String[] args) {
		int[] A = {3,1,2,4,3};
		System.out.println(solution(A));
	}

	public static int solution(int[] A) {
		int subSum1 = 0, subSum2 = 0;
		int difference = Integer.MAX_VALUE;
		
		//subSum1 = 0, subSum2 = 3+1+2+4+3
		for(int arrIndex=0; arrIndex<A.length; arrIndex++) {
			subSum2 += A[arrIndex];
		}

		//subSum1 = 3, subSum2 = 1+2+4+3
		for(int splitIndex=0; splitIndex<A.length-1; splitIndex++) {
			subSum1 += A[splitIndex];
			subSum2 -= A[splitIndex];
			difference = Math.min(difference, Math.abs(subSum1-subSum2));
		}
				
		return difference;
	}
}

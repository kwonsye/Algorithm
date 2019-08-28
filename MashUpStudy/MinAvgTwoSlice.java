package pck1.MashUpStudy;

/*코딜리티 실행결과 100%
 * https://app.codility.com/demo/results/trainingE8J2SP-S8F/
 * */
public class MinAvgTwoSlice {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {4,2,2,5,1,5,8})); //expected 1
	}
	public static int solution(int[] A) {
		int[] prefixSum = new int[A.length+1]; // 0 4 6 8 13 14 19 27
		int minArrIndex=0;
		double minAvg = Double.MAX_VALUE;
		
		//누적 합 계산
		for(int arrIndex=0; arrIndex<A.length; arrIndex++) {
			prefixSum[arrIndex+1] = prefixSum[arrIndex] + A[arrIndex];
		}
	
		//2개 원소 합 중 min 평균 값 찾기
		double tempAvg;
		for(int arrIndex = 0; arrIndex+2 < prefixSum.length; arrIndex++) {
			tempAvg = (prefixSum[arrIndex+2]-prefixSum[arrIndex])/2.0;
			if(tempAvg < minAvg) {
				minArrIndex = arrIndex;
				minAvg = tempAvg;
			}
		}
		
		//3개 원소 합 중 min 평균 값 찾기
		for(int arrIndex = 0; arrIndex+3 < prefixSum.length; arrIndex++) {
			tempAvg = (prefixSum[arrIndex+3]-prefixSum[arrIndex])/3.0;
			if(tempAvg < minAvg) {
				minArrIndex = arrIndex;
				minAvg = tempAvg;
			}
		}
		
		return minArrIndex;
	}
}

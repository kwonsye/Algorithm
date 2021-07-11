package MashUpStudy;

/*�ڵ���Ƽ ������ 100%
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
		
		//���� �� ���
		for(int arrIndex=0; arrIndex<A.length; arrIndex++) {
			prefixSum[arrIndex+1] = prefixSum[arrIndex] + A[arrIndex];
		}
	
		//2�� ���� �� �� min ��� �� ã��
		double tempAvg;
		for(int arrIndex = 0; arrIndex+2 < prefixSum.length; arrIndex++) {
			tempAvg = (prefixSum[arrIndex+2]-prefixSum[arrIndex])/2.0;
			if(tempAvg < minAvg) {
				minArrIndex = arrIndex;
				minAvg = tempAvg;
			}
		}
		
		//3�� ���� �� �� min ��� �� ã��
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

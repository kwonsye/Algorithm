package MashUpStudy;

/* �ڵ���Ƽ Lesson4_3 ���� ��� 
 * TimeComplexity : O(N+M)
 * https://app.codility.com/demo/results/trainingA8RZYU-3D9/
*/
public class MaxCounters {

	public static void main(String[] args) {
		for(int answer : solution(5, new int[]{3,4,4,6,1,4,4})) {
			System.out.print(answer + " ");
		}
	}
	
	public static int[] solution(int N, int[] A) {
		int[] countersArr = new int[N];
		int maxCounter = 0; // A ����==N+1�϶� set�� max �� 
		int presentMax = 0; // countersArr ���� �� max��
		
		for(int arrIndex = 0; arrIndex<A.length; arrIndex++) {
			if(A[arrIndex] == N+1) {
				maxCounter = presentMax;
			} else {
				if(maxCounter > countersArr[A[arrIndex]-1]) {
					countersArr[A[arrIndex]-1] = maxCounter; //maxCounter���� �۴ٸ� maxCounter�� set���ֱ�
				}
				countersArr[A[arrIndex]-1]++; //counter X is increased by 1
				presentMax = Math.max(presentMax, countersArr[A[arrIndex]-1]); //countersArr�� ���� �� max�� ������Ʈ
			}
		}
		
		//maxCounter �������� set
		for(int arrIndex=0; arrIndex<countersArr.length; arrIndex++) {
			if(countersArr[arrIndex]<maxCounter) countersArr[arrIndex] = maxCounter;
		}
		
		return countersArr;
	}

}

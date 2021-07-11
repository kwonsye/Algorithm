package MashUpStudy;

import java.util.Arrays;

/* �ڵ���Ƽ Lesson4_4 ���� ��� 
 * TimeComplexity : O(NlogN)
 * https://app.codility.com/demo/results/trainingE9QUYR-4YQ/
*/

public class MissingInteger {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {1, 3, 6, 4, 1, 2})); //expected 5
		System.out.println(solution(new int[] {1,2,3})); //expected 4
		System.out.println(solution(new int[] {-1,-3})); //expected 1
	}

	 public static int solution(int[] A) {
		 int answer = 1;
		 //sort 1 1 2 3 4 6
		 Arrays.sort(A);
		 
		 for(int arrIndex=0; arrIndex<A.length; arrIndex++) {
			 if(answer == A[arrIndex]) answer++;
			 if(answer < A[arrIndex]) break; //���������ʴ´ٸ� for�� ������
		 }
		 return answer;
	 }
}

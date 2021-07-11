package MashUpStudy;

import java.util.HashSet;
import java.util.Set;

/* �ڵ���Ƽ Lesson4_2 ���� ��� 
 * TimeComplexity : O(N)
 * https://app.codility.com/demo/results/training2TFY9N-NR6/
*/
public class FrogRiverOne {

	public static void main(String[] args) {
		System.out.println(solution(5, new int[]{1,3,1,4,2,3,5,4}));
	}
	public static int solution(int X, int[] A) {
		//�ߺ� ��ġ�� �������� �����ϱ� ���� �ؽü� �̿�
		Set<Integer> leavesPosition = new HashSet<>();
		
		for(int arrIndex = 0; arrIndex < A.length; arrIndex++) {
			//������ ���� ����� ��ġ�� �������� �͸� �����Ѵ�.
			if(A[arrIndex] <= X) leavesPosition.add(A[arrIndex]);
			//�������� ���������� �� �� �ִ� ���
			if(leavesPosition.size() == X) return arrIndex;
		}
		return -1;
	}
}

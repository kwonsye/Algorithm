package MashUpStudy;

import java.util.Arrays;

/*�ڵ���Ƽ ������
 * https://app.codility.com/demo/results/trainingTE4RN8-5BH/
 * */
public class Triangle {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 10, 2, 5, 1, 8, 20 }));
	}

	public static int solution(int[] A) {
		// sort
		Arrays.sort(A); // 1 2 5 8 10 20

		for (int arrIndex = 0; arrIndex + 2 < A.length; arrIndex++) {
			//if(A[arrIndex]+A[arrIndex+1]>A[arrIndex+2]) //�����÷�
			if(A[arrIndex + 1] > A[arrIndex + 2] - A[arrIndex])
				return 1;
		}
		return 0;
	}
}

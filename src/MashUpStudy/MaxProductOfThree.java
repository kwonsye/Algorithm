package MashUpStudy;

import java.util.Arrays;

/* ÄÚµô¸®Æ¼ Lesson6_1 ½ÇÇà °á°ú
 * https://app.codility.com/demo/results/training8524RV-QUH/
 */
public class MaxProductOfThree {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {-3,1,2,-2,5,6})); //expected 60
		System.out.println(solution(new int[] {-5,-3,-2,-1})); //expected -6
		System.out.println(solution(new int[] {-5,-3,-1,2})); //expected 30
	}

	public static int solution(int[] A) {
		Arrays.sort(A); // -3 -2 1 2 5 6
		
		return Math.max(A[A.length-1]*A[A.length-2]*A[A.length-3], A[0]*A[1]*A[A.length-1]);
	}
}

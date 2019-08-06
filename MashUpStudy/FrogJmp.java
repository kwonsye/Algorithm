package pck1.MashUpStudy;

/* 코딜리티 Lesson3_1 실행 결과
 * https://app.codility.com/demo/results/training96N9EM-BGM/
*/
public class FrogJmp {

	public static void main(String[] args) {
		System.out.println(solution(10,110,30));
	}

	public static int solution(int X, int Y, int D) {
		return (int) Math.ceil((Y-X)/(double)D);
	}
}

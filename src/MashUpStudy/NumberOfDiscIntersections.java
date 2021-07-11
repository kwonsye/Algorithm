package MashUpStudy;
// https://app.codility.com/demo/results/trainingAT5SZ8-2AA/
public class NumberOfDiscIntersections {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {1,5,2,1,4,0}));
	}
	
	public static int solution(int[] A) {
		int intersections = 0;
		for(int i=0; i<A.length-1; i++) {
			//���� ���� �� �մ� �ִ��� �ٸ� ���� �ּڰ��� ��
			for(int j=i+1; j<A.length; j++) {
				if(i+(long)A[i] >= j-(long)A[j]) {
					intersections++;
				}
			}
		}
		
		return intersections > 10000000 ? -1 : intersections;
	}

}

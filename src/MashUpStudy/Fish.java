package MashUpStudy;
/* �ڵ���Ƽ ���� ���
 * https://app.codility.com/demo/results/trainingGYA4CJ-H7P/
 * */
import java.util.Stack;

public class Fish {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {4,3,2,1,5}, new int[] {0,1,0,0,0})); //expected 2
	}
	//�ʹ� ��ư� Ǭ �� ������..
	public static int solution(int[] A, int[] B) {
		int upstreamFishCount = 0;
		Stack<Integer> downstreamFishStack = new Stack<>();
		
		for(int fishIndex=0; fishIndex<A.length; fishIndex++) {
			if(B[fishIndex] == 1) { //downstream fish�� ���
				downstreamFishStack.push(A[fishIndex]);
			} else { //upstream fish�� ���
				if(downstreamFishStack.size() == 0) {
					//���� fish�� ���� ���
					upstreamFishCount++;
				}else {
					//���� fish�� �ִٸ� ������ ����� ������ pop�ؼ� ũ���
					while(downstreamFishStack.size()>0) {
						if(A[fishIndex]>downstreamFishStack.peek()) { //downstream fish ��Ƹ���
							downstreamFishStack.pop();
						} else {
							break;
						}
					}
					if(downstreamFishStack.size()==0) { 
						//���ÿ� �ִ� downstream fish���� upstream fish �Ѹ����� ��� ��Ƹ���
						upstreamFishCount++;
					}
				}
			}
		}
		
		return upstreamFishCount + downstreamFishStack.size();
	}
}

package pck1.MashUpStudy;
/* 코딜리티 실행 결과
 * https://app.codility.com/demo/results/trainingGYA4CJ-H7P/
 * */
import java.util.Stack;

public class Fish {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {4,3,2,1,5}, new int[] {0,1,0,0,0})); //expected 2
	}
	//너무 어렵게 푼 것 같은데..
	public static int solution(int[] A, int[] B) {
		int upstreamFishCount = 0;
		Stack<Integer> downstreamFishStack = new Stack<>();
		
		for(int fishIndex=0; fishIndex<A.length; fishIndex++) {
			if(B[fishIndex] == 1) { //downstream fish일 경우
				downstreamFishStack.push(A[fishIndex]);
			} else { //upstream fish일 경우
				if(downstreamFishStack.size() == 0) {
					//비교할 fish가 없는 경우
					upstreamFishCount++;
				}else {
					//비교할 fish가 있다면 스택이 비워질 때까지 pop해서 크기비교
					while(downstreamFishStack.size()>0) {
						if(A[fishIndex]>downstreamFishStack.peek()) { //downstream fish 잡아먹힘
							downstreamFishStack.pop();
						} else {
							break;
						}
					}
					if(downstreamFishStack.size()==0) { 
						//스택에 있던 downstream fish들을 upstream fish 한마리가 모두 잡아먹음
						upstreamFishCount++;
					}
				}
			}
		}
		
		return upstreamFishCount + downstreamFishStack.size();
	}
}

package pck1.MashUpStudy;

public class BinaryGap {

	public static void main(String[] args) {
		int N = 32;
		System.out.println(solution(N));
	}
	
	 public static int solution(int N) {
		 
		 int zeroCount=0; //0 개수
		 int maxGap = 0; //최대 0 개수 = 반환값
		 boolean isFirstFlag = true; //최초 1이 나오기 전 = true  
		 //2진수
		 while(N>=1) {	
			 int binaryValue = N % 2;
			 
			 if(isFirstFlag && binaryValue == 1) {
				 isFirstFlag = false;
			 }else if(!isFirstFlag && binaryValue == 0) {
				 //0개수 세기
				 zeroCount++;
			 } else if(!isFirstFlag && binaryValue == 1) {
				 if(maxGap < zeroCount) {
					 maxGap = zeroCount; 
				 }
				 zeroCount = 0;
			 }
			 N /= 2;
		 }
		 return maxGap;
	 }

}

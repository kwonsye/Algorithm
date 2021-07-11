package MashUpStudy;

public class BinaryGap {

	public static void main(String[] args) {
		int N = 32;
		System.out.println(solution(N));
	}
	
	 public static int solution(int N) {
		 
		 int zeroCount=0; //0 ����
		 int maxGap = 0; //�ִ� 0 ���� = ��ȯ��
		 boolean isFirstFlag = true; //���� 1�� ������ �� = true  
		 //2����
		 while(N>=1) {	
			 int binaryValue = N % 2;
			 
			 if(isFirstFlag && binaryValue == 1) {
				 isFirstFlag = false;
			 }else if(!isFirstFlag && binaryValue == 0) {
				 //0���� ����
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

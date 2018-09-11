package pck1;

import java.util.Scanner;
/*백준 알고리즘 1052 물병*/
public class Bottle {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int beforeBottleCount=sc.nextInt();
		//더 필요한 물병개수 세기 위한 변수
		int afterBottleCount=beforeBottleCount;
		int limit=sc.nextInt();
		
		while(true) {
			int oneCount=0;//이진수에서의 1의 개수가 최종으로 만들수있는 물병 수
			//이진수 문자열로 저장
			String binaryString=Integer.toBinaryString(afterBottleCount);
			
			//이진수 문자열에서 1의 개수찾기
			for(int i=0;i<binaryString.length();i++) {
				if(binaryString.charAt(i)=='1')
					oneCount++;
			}
			
			if(oneCount<=limit)
				break;
			else if(oneCount>limit)//물병개수를 더 줄여야한다면 가게에서 1L 사와야한다.
				afterBottleCount++;
		}
		
		//break로 나오면 찾은것이기 때문에 사온 물병개수 세어주면 됨
		System.out.println(afterBottleCount-beforeBottleCount);
		
		sc.close();
	}

}
	


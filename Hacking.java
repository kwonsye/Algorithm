package pck1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*1325 효율적인 해킹*/
public class Hacking {
	
	public static void main(String[] args) {
	//맵핑할 맵
	Map<Integer,ArrayList<Integer>> map=new HashMap<Integer,ArrayList<Integer>>();
	
	Scanner sc=new Scanner(System.in);
	int computerCount=sc.nextInt();//컴퓨터개수
	int rowCount=sc.nextInt();//줄개수
	
	//미리 리스트만들어서 넣어놓기
	for(int computer=1;computer<=computerCount;computer++) {
		map.put(computer, new ArrayList<Integer>());
	}
	
	for(int i=1;i<=rowCount;i++) {
		int trustSubject=sc.nextInt();//신뢰주체
		int trustedObject=sc.nextInt();//신뢰주체가 신뢰하는 대상
		
		//맵핑
		map.get(trustedObject).add(trustSubject);
	}
	
	//연결된 컴퓨터개수 저장해놓은 배열만들기
	int[] array=new int[computerCount+1];

	for(int computer=1;computer<=computerCount;computer++) {
		int count=counting(map,computer);
		array[computer]=count;
	}
	
	//array값중에 가장 큰게 효율높은 해킹컴퓨터
	int max=0;
	for(int i=1;i<array.length;i++) {
		if(max<=array[i])
			max=array[i];
		
	}
	
	//max값을 가진 모든 원소 오름차순출력
	for(int i=1;i<array.length;i++) {
		if(max==array[i])
			System.out.print(i+" ");
	}
	sc.close();

	
}
	//연결된 컴퓨터개수 카운팅해주는 재귀함수
	static int counting(Map<Integer, ArrayList<Integer>> map,int computer) {
		int count=0;
		if(map.get(computer).size()==0)
			return 0;
		else {
			count+=(map.get(computer).size());
			for(int i=0;i<map.get(computer).size();i++)
				count+=counting(map,map.get(computer).get(i));
			return count;
		}

	}
}

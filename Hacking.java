package pck1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*1325 ȿ������ ��ŷ*/
public class Hacking {
	
	public static void main(String[] args) {
	//������ ��
	Map<Integer,ArrayList<Integer>> map=new HashMap<Integer,ArrayList<Integer>>();
	
	Scanner sc=new Scanner(System.in);
	int computerCount=sc.nextInt();//��ǻ�Ͱ���
	int rowCount=sc.nextInt();//�ٰ���
	
	//�̸� ����Ʈ���� �־����
	for(int computer=1;computer<=computerCount;computer++) {
		map.put(computer, new ArrayList<Integer>());
	}
	
	for(int i=1;i<=rowCount;i++) {
		int trustSubject=sc.nextInt();//�ŷ���ü
		int trustedObject=sc.nextInt();//�ŷ���ü�� �ŷ��ϴ� ���
		
		//����
		map.get(trustedObject).add(trustSubject);
	}
	
	//����� ��ǻ�Ͱ��� �����س��� �迭�����
	int[] array=new int[computerCount+1];

	for(int computer=1;computer<=computerCount;computer++) {
		int count=counting(map,computer);
		array[computer]=count;
	}
	
	//array���߿� ���� ū�� ȿ������ ��ŷ��ǻ��
	int max=0;
	for(int i=1;i<array.length;i++) {
		if(max<=array[i])
			max=array[i];
		
	}
	
	//max���� ���� ��� ���� �����������
	for(int i=1;i<array.length;i++) {
		if(max==array[i])
			System.out.print(i+" ");
	}
	sc.close();

	
}
	//����� ��ǻ�Ͱ��� ī�������ִ� ����Լ�
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

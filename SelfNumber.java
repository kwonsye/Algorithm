package pck1;
import java.util.HashMap;
import java.util.Map;

public class SelfNumber{
	//�����ѹ��� �ƴѰ� ����ϴ��Լ�
	static int isNotSelfNumber(int n)
	{
		int result=0;
		result+=n;
		if(n>=1000) {
			result+=n/1000;
			n=n%1000;
			
		}

		if(n>=100) {
			result+=n/100;
			n=n%100;
		}

		if(n>=10) {
			result+=n/10;
			n=n%10;
		}
		if(n>=0) {
			result+=n;
		}

		return result;
	}

	public static void main(String[] args) {
		
		Map<Integer,Integer> notSelfNumberMap=new HashMap<Integer,Integer>(); //�����ѹ��ƴѰ� �����ϴ� ��
		int value;
		
		for(int n=1;n<10000;n++) {
			value=isNotSelfNumber(n);
			notSelfNumberMap.put(n,value);//�����ѹ��� �ƴѰ͵� �ʿ� ����		  
		}
		
		boolean flag = true;

		//���� value���� ���������ʴ°� �����ѹ�
		for(int n=1;n<10000;n++) {
			flag = true;
			for(int key:notSelfNumberMap.keySet()) {
				if(n==notSelfNumberMap.get(key))
					{flag = false; break;}
				}
			if(flag==true)
				System.out.println(n);//�����ѹ����
		}		
	}
}


	


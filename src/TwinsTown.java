import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
/*1098 �ֵ��̸���*/
public class TwinsTown {

	static class TownPoint{
		int x;
		int y;
		Map<Integer,Integer> distanceMap; //�ٸ� ��������� �Ÿ�<Key:�Ÿ�,Value:�����ε���>
		
		TownPoint(int x,int y){
			this.x=x;
			this.y=y;
			distanceMap=new TreeMap<Integer,Integer>();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int townsCount=sc.nextInt();
		
		//������ ��ǥ�� townpoints�迭�� ����
		TownPoint[] townPoints=new TownPoint[townsCount];
		int x,y;
		for(int count=0;count<townsCount;count++) {
			x=sc.nextInt();
			y=sc.nextInt();
			townPoints[count]=new TownPoint(x,y);
		}
		
		int twinTownsLimit=sc.nextInt();
		int minTwinTownsDistance=sc.nextInt();
		
		List<Integer> twinTownsLimitCheckList=new ArrayList<Integer>();//�ֵ��̸����� �ִ밪 Ȯ�������� ����Ʈ
		//(�ε���:�����ε���,����Ʈ��:�ش� ������ ����� �ִ� �ִ� �ֵ��̸��� ��)
		for(int townIndex=0;townIndex<townsCount;townIndex++)
			twinTownsLimitCheckList.add(twinTownsLimit);//�ʱ�ȭ
		
		//�� ���� ������ �Ÿ� ���
		int distance;
		for(int townIndex=0;townIndex<townsCount;townIndex++) {
			for(int comparedIndex=townIndex+1;comparedIndex<townsCount;comparedIndex++) {
				distance=calculateDistance(townPoints[townIndex],townPoints[comparedIndex]);
				if(distance>=minTwinTownsDistance)
					townPoints[townIndex].distanceMap.put(distance, comparedIndex);
			}
		}
		//�ֵ��̸����� ����� �ִ��� ���� Ȯ��
		int distanceBetweenTwinTowns=0;
		for(int townIndex=0;townIndex<townsCount;townIndex++) {
			for(int key:townPoints[townIndex].distanceMap.keySet()) {
				int comparedIndex=townPoints[townIndex].distanceMap.get(key);
				
				//������ִ� �ֵ��� ���� ������ 0���� �ƴϸ� �ֵ��� ������ ����� �ֵ��̸��������� �Ÿ��� ����
				distanceBetweenTwinTowns+=makeTwinTowns(townPoints,twinTownsLimitCheckList,townIndex,comparedIndex);
			}	
		}
		
		//������� �ֵ��̸����� ������ ����
		int twinTown=((twinTownsLimit*townsCount)-totalSumOfList(twinTownsLimitCheckList))/2;
		
		System.out.print(twinTown+" "+distanceBetweenTwinTowns);					
		sc.close();
	}
	
	static int calculateDistance(TownPoint point1,TownPoint point2) {
		return (Math.abs(point1.x-point2.x)+Math.abs(point1.y-point2.y));
	}
	
	static int makeTwinTowns(TownPoint[] townPoints,List<Integer> twinTownsLimitCheckList,int townIndex,int comparedIndex) {
		//�ֵ��� ������ �����.
		if((twinTownsLimitCheckList.get(townIndex)!=0)&&(twinTownsLimitCheckList.get(comparedIndex)!=0)) {
			twinTownsLimitCheckList.set(townIndex, twinTownsLimitCheckList.get(townIndex)-1);
			twinTownsLimitCheckList.set(comparedIndex, twinTownsLimitCheckList.get(comparedIndex)-1);
			return (calculateDistance(townPoints[townIndex],townPoints[comparedIndex]));
		}
		return 0;
	}
	
	static int totalSumOfList(List<Integer> list) {
		int sum=0;
		for(int component:list)
			sum+=component;
		return sum;
	}

}

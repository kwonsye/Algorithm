package pck1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
/*1098 쌍둥이마을*/
public class TwinsTown {

	static class TownPoint{
		int x;
		int y;
		Map<Integer,Integer> distanceMap; //다른 마을들과의 거리<Key:거리,Value:마을인덱스>
		
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
		
		//마을의 좌표들 townpoints배열에 저장
		TownPoint[] townPoints=new TownPoint[townsCount];
		int x,y;
		for(int count=0;count<townsCount;count++) {
			x=sc.nextInt();
			y=sc.nextInt();
			townPoints[count]=new TownPoint(x,y);
		}
		
		int twinTownsLimit=sc.nextInt();
		int minTwinTownsDistance=sc.nextInt();
		
		List<Integer> twinTownsLimitCheckList=new ArrayList<Integer>();//쌍둥이마을의 최대값 확인을위한 리스트
		//(인덱스:마을인덱스,리스트값:해당 마을이 만들수 있는 최대 쌍둥이마을 수)
		for(int townIndex=0;townIndex<townsCount;townIndex++)
			twinTownsLimitCheckList.add(twinTownsLimit);//초기화
		
		//각 마을 사이의 거리 계산
		int distance;
		for(int townIndex=0;townIndex<townsCount;townIndex++) {
			for(int comparedIndex=townIndex+1;comparedIndex<townsCount;comparedIndex++) {
				distance=calculateDistance(townPoints[townIndex],townPoints[comparedIndex]);
				if(distance>=minTwinTownsDistance)
					townPoints[townIndex].distanceMap.put(distance, comparedIndex);
			}
		}
		//쌍둥이마을을 만들수 있는지 여부 확인
		int distanceBetweenTwinTowns=0;
		for(int townIndex=0;townIndex<townsCount;townIndex++) {
			for(int key:townPoints[townIndex].distanceMap.keySet()) {
				int comparedIndex=townPoints[townIndex].distanceMap.get(key);
				
				//만들수있는 쌍둥이 마을 개수가 0개가 아니면 쌍둥이 마을을 만들고 쌍둥이마을사이의 거리를 리턴
				distanceBetweenTwinTowns+=makeTwinTowns(townPoints,twinTownsLimitCheckList,townIndex,comparedIndex);
			}	
		}
		
		//만들어진 쌍둥이마을의 개수를 센다
		int twinTown=((twinTownsLimit*townsCount)-totalSumOfList(twinTownsLimitCheckList))/2;
		
		System.out.print(twinTown+" "+distanceBetweenTwinTowns);					
		sc.close();
	}
	
	static int calculateDistance(TownPoint point1,TownPoint point2) {
		return (Math.abs(point1.x-point2.x)+Math.abs(point1.y-point2.y));
	}
	
	static int makeTwinTowns(TownPoint[] townPoints,List<Integer> twinTownsLimitCheckList,int townIndex,int comparedIndex) {
		//쌍둥이 마을을 만든다.
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

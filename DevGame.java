package pck1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class DevGame {
/*1516 게임개발*/
	//건물 클래스
	static class Building{
		int buildingTime;
		List<Integer> preBuildList;
		HashSet<Integer> preBuildHashSet;
		//생성자
		private Building(int buildingTime) {
			this.buildingTime=buildingTime;
			
			preBuildList=new ArrayList<Integer>();
			preBuildHashSet=new HashSet<Integer>();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int buildingsCount=sc.nextInt();//건물 개수
		Building[] buildings=new Building[buildingsCount+1];//건물들 배열 생성
		
		int buildingTime;
		int prebuild;
		//건물객체들에 짓는데 걸리는 시간,먼저지어야하는 빌딩번호리스트 저장
		for(int buildingIndex=1;buildingIndex<=buildingsCount;buildingIndex++) {
			buildingTime=sc.nextInt();
			buildings[buildingIndex]=new Building(buildingTime);//빌딩 객체생성
			
			while((prebuild=sc.nextInt())!=-1) {
				buildings[buildingIndex].preBuildList.add(prebuild);	
			}
		}
		
		//각 건물의 해시셋에 먼저지어야하는 총 건물들 추가해주는일 구현
		for(int buildingIndex=1;buildingIndex<=buildingsCount;buildingIndex++) {
		     Building building=buildings[buildingIndex];
		     HashSet<Integer> hashset=building.preBuildHashSet;
		     //자기자신저장
		     hashset.add(buildingIndex);
		     
		     int sizeOfPastHashset=1;
		     int sizeOfPresentHashset;
		     HashSet<Integer> set=new HashSet<Integer>();
		     while(true){
		    	 set=componentsOfPreBuildList(buildings,hashset);//해시셋원소들 각각에 대한 리스트들을 모두 받아와서
		    	 addToHashSet(hashset,set);//자신의 해시셋에 저장
		      
		    	 sizeOfPresentHashset=sizeOfHashset(hashset);
		    	 if(sizeOfPastHashset==sizeOfPresentHashset||sizeOfPresentHashset==buildingsCount)
		    		 //해시셋 확정
		    		 break;
		    	 sizeOfPastHashset=sizeOfPresentHashset;
		     }
		}
		
		//짓는데 총 걸리는시간계산
		int allSpendTime=0;
		for(int buildingIndex=1;buildingIndex<=buildingsCount;buildingIndex++) {
			Building building=buildings[buildingIndex];
			HashSet<Integer> preBuildHashSet=building.preBuildHashSet;
			
			allSpendTime=calculateAllSpendTime(buildings,preBuildHashSet);//해시셋원소들 하나씩 가져와서 걸리는 총시간 계산
			
			System.out.println(allSpendTime);
		}
		
		sc.close();
	}
	
	public static int sizeOfHashset(HashSet<Integer> hashSet) {
		return hashSet.size();
	}
	public static HashSet<Integer> componentsOfPreBuildList(Building[] buildings,HashSet<Integer> hashset){
		
		HashSet<Integer> resultHashset = new HashSet<Integer>();
		List<Integer> list=new ArrayList<Integer>();
		for(int component:hashset) {
			list=buildings[component].preBuildList;
			resultHashset.addAll(list);
		}
		
		return resultHashset;
	}
	
	public static void addToHashSet(HashSet<Integer> SubjectHashset,HashSet<Integer> ObjectHashset){
		
		SubjectHashset.addAll(ObjectHashset);
	}
	
	public static int calculateAllSpendTime(Building[] buildings,HashSet<Integer> hashset) {
		
		int spendTime=0;
		for(int buildingIndex:hashset) {
			spendTime+=buildings[buildingIndex].buildingTime;
		}
		
		return spendTime;
	}

}

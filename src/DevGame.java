import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class DevGame {
/*1516 ���Ӱ���*/
	//�ǹ� Ŭ����
	static class Building{
		int buildingTime;
		List<Integer> preBuildList;
		HashSet<Integer> preBuildHashSet;
		//������
		private Building(int buildingTime) {
			this.buildingTime=buildingTime;
			
			preBuildList=new ArrayList<Integer>();
			preBuildHashSet=new HashSet<Integer>();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int buildingsCount=sc.nextInt();//�ǹ� ����
		Building[] buildings=new Building[buildingsCount+1];//�ǹ��� �迭 ����
		
		int buildingTime;
		int prebuild;
		//�ǹ���ü�鿡 ���µ� �ɸ��� �ð�,����������ϴ� ������ȣ����Ʈ ����
		for(int buildingIndex=1;buildingIndex<=buildingsCount;buildingIndex++) {
			buildingTime=sc.nextInt();
			buildings[buildingIndex]=new Building(buildingTime);//���� ��ü����
			
			while((prebuild=sc.nextInt())!=-1) {
				buildings[buildingIndex].preBuildList.add(prebuild);	
			}
		}
		
		//�� �ǹ��� �ؽü¿� ����������ϴ� �� �ǹ��� �߰����ִ��� ����
		for(int buildingIndex=1;buildingIndex<=buildingsCount;buildingIndex++) {
		     Building building=buildings[buildingIndex];
		     HashSet<Integer> hashset=building.preBuildHashSet;
		     //�ڱ��ڽ�����
		     hashset.add(buildingIndex);
		     
		     int sizeOfPastHashset=1;
		     int sizeOfPresentHashset;
		     HashSet<Integer> set=new HashSet<Integer>();
		     while(true){
		    	 set=componentsOfPreBuildList(buildings,hashset);//�ؽü¿��ҵ� ������ ���� ����Ʈ���� ��� �޾ƿͼ�
		    	 addToHashSet(hashset,set);//�ڽ��� �ؽü¿� ����
		      
		    	 sizeOfPresentHashset=sizeOfHashset(hashset);
		    	 if(sizeOfPastHashset==sizeOfPresentHashset||sizeOfPresentHashset==buildingsCount)
		    		 //�ؽü� Ȯ��
		    		 break;
		    	 sizeOfPastHashset=sizeOfPresentHashset;
		     }
		}
		
		//���µ� �� �ɸ��½ð����
		int allSpendTime=0;
		for(int buildingIndex=1;buildingIndex<=buildingsCount;buildingIndex++) {
			Building building=buildings[buildingIndex];
			HashSet<Integer> preBuildHashSet=building.preBuildHashSet;
			
			allSpendTime=calculateAllSpendTime(buildings,preBuildHashSet);//�ؽü¿��ҵ� �ϳ��� �����ͼ� �ɸ��� �ѽð� ���
			
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

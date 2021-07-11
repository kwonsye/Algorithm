import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Picnic {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int goPicnic = sc.nextInt(); //K
		int totalStudent = sc.nextInt(); //N
		int row = sc.nextInt(); //F
		
		int[][] friendsArray = new int[totalStudent][totalStudent];
		
		//0���� �ʱ�ȭ
		for(int studentCount=0; studentCount<friendsArray.length; studentCount++) {
			for(int friendsCount=0; friendsCount<friendsArray[0].length; friendsCount++) {
				friendsArray[studentCount][friendsCount] =0;
			}
		}
		
		
		
		for(int rowIndex=0; rowIndex<row; rowIndex++) {
			int student1 = sc.nextInt()-1;
			int student2 = sc.nextInt()-1;
			
			friendsArray[student1][student2] = 1;
		}
		
		List<HashSet<Integer>> canGoStudent = new ArrayList<>();
		
		for(int studentCount=0; studentCount<friendsArray.length; studentCount++) {
			int totalFriendsCount = 1;
			List<Integer> friendsList = new ArrayList<>();
			
			for(int friendsCount=0; friendsCount<friendsArray[0].length; friendsCount++) {
				if(friendsArray[studentCount][friendsCount] == 1) {
					totalFriendsCount++;
					friendsList.add(friendsCount);
				}
			}
			
			if(totalFriendsCount >= goPicnic) {
				HashSet<Integer> canGoPicnic= new HashSet<>();
				canGoPicnic.add(studentCount);
				for(int listIndex1=0; listIndex1<friendsList.size()-1; listIndex1++) {
					for(int listIndex2=listIndex1+1; listIndex2<friendsList.size(); listIndex2++) {
						if(friendsArray[friendsList.get(listIndex1)][friendsList.get(listIndex2)] == 1) {
							canGoPicnic.add(friendsList.get(listIndex1));
							canGoPicnic.add(friendsList.get(listIndex2));
						}
					}
				}
				
				if(canGoPicnic.size() == goPicnic) {
					canGoStudent.add(canGoPicnic);
				}
			}
		}
		
		if(canGoStudent.size()==0) {
			System.out.println(-1);
		}
		
		else if(canGoStudent.size() == 1) {
			for(int canGo : canGoStudent.get(0)) {
				System.out.println(canGo+1);
			}
		}
		
		else {
			for (int index1 = 0; index1 < canGoStudent.size() - 1; index1++) {
				for (int index2 = index1 + 1; index2 < canGoStudent.size(); index2++) {
					HashSet<Integer> set1 = canGoStudent.get(index1);
					HashSet<Integer> set2 = canGoStudent.get(index2);

					List<Integer> list1 = new ArrayList<>(set1);
					List<Integer> list2 = new ArrayList<>(set2);

					for (int index = 0; index < list1.size(); index++) {
						
						if(list1.get(index) == list2.get(index)) {
							continue;
						}
						else if (list1.get(index) < list2.get(index)) {
							for(int canGo : list1) {
								System.out.println(canGo+1);
							}
							break;
						}
						
						else {
							for(int canGo : list2) {
								System.out.println(canGo+1);
							}
							break;
						}

					}

				}
			}
		}
		/*
		for(int studentCount=0; studentCount<friendsArray.length; studentCount++) {
			for(int friendsCount=0; friendsCount<friendsArray[0].length; friendsCount++) {
				System.out.print(friendsArray[studentCount][friendsCount]);
			}
			System.out.println("");
		}*/
	}

}

package pck1;

import java.util.Scanner;
import java.util.Vector;

public class ShortestPath {
	final static int MAX=1000; //무한대를 의미
	
	public static void main(String[] args) {
		int[][] graph = {
				{0,12,15,MAX,MAX,MAX,MAX,MAX,MAX,MAX},
				{12,0,MAX,MAX,4,10,MAX,MAX,MAX,MAX},
				{15,MAX,0,21,MAX,MAX,7,MAX,MAX,MAX},
				{MAX,MAX,21,0,MAX,MAX,MAX,25,MAX,MAX},
				{4,MAX,MAX,MAX,0,3,MAX,MAX,13,MAX},
				{MAX,10,MAX,MAX,3,0,10,MAX,MAX,MAX},
				{MAX,MAX,7,MAX,MAX,10,0,19,MAX,9},
				{MAX,MAX,MAX,25,MAX,MAX,19,0,MAX,5},
				{MAX,MAX,MAX,MAX,13,MAX,MAX,MAX,0,15},
				{MAX,MAX,MAX,MAX,MAX,MAX,9,5,15,0}
		};
		
		int temp=0; //서울에서 시작
		Vector<Integer> vertexes = new Vector<>(); //순차적으로 변경되는 temp들이 저장되는 벡터
		int[] dist = new int[graph.length]; //서울에서 각 index정점까지의 거리를 저장하는 배열
		boolean[] isVisit = new boolean[graph.length]; //방문했는지 여부 체크함 
		
		//dist배열 초기화
		dist = graph[0];
		
		//isVisit 초기화
		for(int index=0;index<isVisit.length;index++) {
			isVisit[index] = false;
		}
		//vertexes와 isVisit초기화
		vertexes.add(temp);
		isVisit[temp]=true;
		
		while(true) {
			if(vertexes.size() == graph.length)
				break;
			
			//dist중에 0을 제외한 가장 작은 값의 인덱스를 가져온다.
			int min = Integer.MAX_VALUE;
			for(int index=0;index<dist.length;index++) {
				if(isVisit[index]==false && dist[index]<min) {
					min = index;
				}
			}
			temp = min; //temp값 업데이트
			vertexes.add(temp);
			isVisit[temp]=true;
			
			//dist업데이트
			for(int index=0; index<graph[0].length; index++) {
				if(!isVisit[index]) //방문하지 않은경우만
					dist[index]=Math.min(dist[index], dist[temp]+graph[temp][index]);
			}
			
		}
		
		//사용자 입력부분
		Scanner sc = new Scanner(System.in);

		while(true) {
			String destination = sc.next();

			System.out.print("최단 경로의 길이:");

			switch (destination) {
			case "서울":
				System.out.println(dist[0]);
				break;
			case "천안":
				System.out.println(dist[1]);
				break;
			case "원주":
				System.out.println(dist[2]);
				break;
			case "강릉":
				System.out.println(dist[3]);
				break;
			case "논산":
				System.out.println(dist[4]);
				break;
			case "대전":
				System.out.println(dist[5]);
				break;
			case "대구":
				System.out.println(dist[6]);
				break;
			case "포항":
				System.out.println(dist[7]);
				break;
			case "광주":
				System.out.println(dist[8]);
				break;
			case "부산":
				System.out.println(dist[9]);
				break;
			}
		}
		//sc.close();
	}
		
}


